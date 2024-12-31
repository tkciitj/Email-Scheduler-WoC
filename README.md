# EMAIL SCHEDULER Project (WoC)

## Setup Instructions

### 1. Install Dependencies

Every time you pull the latest changes from the repository, run the following commands to ensure all dependencies are installed:

- In the **pom.xml** file add:

  ```bash
  <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
  ```

- In the **frontend** folder:
  ```bash
  yet to edit
  ```

### 2. Start the Application

To start the application, run the following command in the **root** folder:

```bash
yet to edit
```

This will start both the backend and frontend (if configured in the scripts).

## API Endpoints

All API endpoints are prefixed with: `http://localhost:<portnumber>`.

### Authentication

Add your gmail credentials in application.properties or application.yml file, it should look like this:
```bash
spring.application.name=first
# Gmail SMTP Server Settings
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=youremail@gmail.com    # Your Gmail email address
spring.mail.password=YOURPASSWORD   # App Password if using 2FA (Otherwise, use your regular Gmail password)
spring.mail.properties.mail.smtp.auth=true  # Enable SMTP authentication
spring.mail.properties.mail.smtp.starttls.enable=true  # Enable TLS for secure connection
spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com  # Trust SMTP server
```

## Json files for POST

### Send single Email

- **URL:** `/email/send`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "to": "youremail@gmail.com",
    "subject": "Invitation to Participate in Campus Placement and Internship at IIT Jodhpur",
    "text": "Dear Sir,\n\nGreetings from IIT Jodhpur!\n\nOn behalf of the Placement Cell at IIT Jodhpur, I, Arman, Internship Representative, take this        opportunity to invite Google to participate in our campus placement and internship season for the 2025 and 2026 batches, respectively.\n\nSince its        inception in 2008, IIT Jodhpur has achieved several milestones and has always strived to push its limits in all spheres. The institute has a large         pool of talented students pursuing their interests through a wide range of academic programs. Notably, IIT Jodhpur secured the 29th rank in NIRF           2024.\n\nIIT Jodhpur stands out with its Industry 4.0 curriculum, interdisciplinary projects, and mandatory courses in Machine Learning and Data           Structures for all branches. Our students are actively engaged in various tech and non-tech clubs ensuring they are well-rounded and industry-             ready.\n\nWhy Collaborate with IIT Jodhpur?\nQualified Talent Pool: Our students undergo rigorous training and excel both academically and                 practically.\nDiverse Skill Sets: Programs offered include B.Tech, BS, M.Tech, M.Sc, Ph.D., and dual degrees across various departments.\nInnovative       Learning: Our curriculum is updated with the latest industry trends and technologies, focusing on emerging domains like Artificial Intelligence, IoT,      and Computational Sciences.\nInterdisciplinary Projects & Research: Students engage in projects that integrate multiple disciplines, preparing them 
    for complex industry challenges.\nActive Clubs: Tech and non-tech clubs, such as Product, DevLup Labs, RAID, Robotics Society, and E-Cell, contribute      to the holistic development of our students.\n\nPLACEMENTS\nPrograms Offered\tAvailable Batch Strength\nB.Tech\t440\nM.Tech\t210\nM.Sc\t80\nTech           MBA\t80\n\nINTERNSHIPS\nPrograms Offered\tAvailable Batch Strength\nB.Tech\t500\nTech MBA\t120\n\nFor more details, please find the brochure attached.     We invite you to consider our students for both technical and non-technical roles. Kindly fill out and return the attached Job (JAF) / Internship          (IAF) Announcement Form to expedite the process.\n\nWe look forward to a long-term relationship with your organization. For any queries, feel free to      contact me or our team.\n\nWarm Regards,\nArman\nInternship Representative\nCareer Development Cell | IIT Jodhpur\nContact: +91                            8.273072067E9\n\nAlternate Contact:\nPuneet Garg\nTraining & Placement Officer\nCareer Development Cell | IIT Jodhpur\nContact: +91 9815964823, 0291-      2801155"
  }
  ```
- **Response:**
  - **Success (200):**
    ```json
    {
      Email sent successfully!
    }
    ```
