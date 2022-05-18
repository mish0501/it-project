package com.misho0501.servlets;

import com.google.gson.Gson;
import com.misho0501.beans.Address;
import com.misho0501.beans.JsonResult;
import com.misho0501.beans.Skill;
import com.misho0501.beans.User;
import com.misho0501.repository.Repository;
import helpers.ReaderWorker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProfileEdit", urlPatterns = {"/user/edit"})
public class ProfileEdit extends HttpServlet {
    Repository repository;
    Gson gson;

    public void init() {
        repository = Repository.getInstance();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login?error=" + URLEncoder.encode("Трябва да сте логнати, за да видите страницата", "UTF-8"));
            return;
        }

        request.getRequestDispatcher("/public/user/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        String json = ReaderWorker.read(request.getReader());

        Map<String, String> map = gson.fromJson(json, Map.class);
        String mode = map.get("mode");

        JsonResult result = new JsonResult();

        if (mode != null) {
            try {
                switch (mode) {
                    case "basicInfo":
                        updateBasicInfo(user, map);
                        break;
                    case "skills":
                        updateSkills(user, map);
                        break;
                    case "contact":
                        updateContact(user, map);
                        break;
                    default:
                        throw new IllegalArgumentException("Възникна грешка");
                }
            } catch (IllegalArgumentException e) {
                result.setMessage(e.getMessage());
            }
        }

        if(result.getMessage() == null) {
            result.setMessage("Успешно променени данни");
        }

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(result));
        out.flush();
    }

    private void updateBasicInfo(User user, Map<String, String> data) throws IOException {
        String name = data.get("name"),
                job = data.get("jobTitle"),
                description = data.get("description");

        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Името не може да е празно");
        }

        if(job == null || job.isEmpty()) {
            throw new IllegalArgumentException("Работа не може да е празна");
        }

        if(description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Описанието не може да е празно");
        }

        user.updateBasicInfo(name, job, description);
    }

    private void updateSkills(User user, Map<String, String> data) throws IOException {
        List<Skill> jobSkills = user.getJobSkills();
        List<Skill> personalSkills = user.getPersonalSkills();

        for (Skill skill : jobSkills) {
            if(data.containsKey(skill.getName())) {
                skill.setPercent(Float.parseFloat(data.get(skill.getName())));
            }
        }

        for (Skill skill : personalSkills) {
            if(data.containsKey(skill.getName())) {
                skill.setPercent(Float.parseFloat(data.get(skill.getName())));
            }
        }

        user.updateSkills(jobSkills, personalSkills);
    }

    private void updateContact(User user, Map<String, String> data) throws IOException {
        String street = data.get("street"),
                city = data.get("city"),
                phone = data.get("phone"),
                email = data.get("email");

        if(street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Адресът не може да е празен");
        }

        if(city == null || city.isEmpty()) {
            throw new IllegalArgumentException("Градът не може да е празен");
        }

        if(phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Телефонът не може да е празен");
        }

        if(email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Електронната поща не може да е празна");
        }

        user.updateContact(street, city, phone, email);
    }
}
