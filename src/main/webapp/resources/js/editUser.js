const basicInfoButton = document.getElementById("basicInfoButton");
const skillsButton = document.getElementById("skillsButton");
const contactsButton = document.getElementById("contactsButton");

// Basic info

basicInfoButton.addEventListener("click", function(e) {
    e.preventDefault();

    const formData = new FormData();
    formData.append("name", document.getElementsByName("name")[0].value);
    formData.append("jobTitle", document.getElementsByName("jobTitle")[0].value);
    formData.append("description", document.getElementsByName("description")[0].value);

    formData.append("mode", "basicInfo");

    postData(formData);
});

// Skills

skillsButton.addEventListener("click", function(e) {
    e.preventDefault();

    const formData = new FormData();

    const jobSkills = document.getElementsByClassName("jobSkills");
    for (let i = 0; i < jobSkills.length; i++) {
        formData.append(jobSkills[i].getAttribute("name"), jobSkills[i].value);
    }

    const personalSkills = document.getElementsByClassName("personalSkills");
    for (let i = 0; i < personalSkills.length; i++) {
        formData.append(personalSkills[i].getAttribute("name"), personalSkills[i].value);
    }

    formData.append("mode", "skills");

    postData(formData);
});

// Contacts

contactsButton.addEventListener("click", function(e) {
    e.preventDefault();

    const formData = new FormData();
    formData.append("email", document.getElementsByName("email")[0].value);
    formData.append("phone", document.getElementsByName("phone")[0].value);
    formData.append("street", document.getElementsByName("street")[0].value);
    formData.append("city", document.getElementsByName("city")[0].value);

    formData.append("mode", "contact");

    postData(formData);
});

function postData(formData) {
    fetch("/user/edit", {
        headers:{
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(Object.fromEntries(formData))
    }).then(function(response) {
        return response.json();
    }).then(function(data) {
        console.log(data);
    }).catch(function(error) {
        console.error(error);
    })
}
