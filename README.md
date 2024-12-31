# EMAIL SCHEDULER Project (WoC)

## Setup Instructions

### 1. Install Dependencies

Every time you pull the latest changes from the repository, run the following commands to ensure all dependencies are installed:

- In the **pom.xml** file add:

  ```bash
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

### 1). Send single Email

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
  - **Error (400):**
    ```json
    {
      "message": "Invalid request data"
    }
    ```
    
### 2. Schedule Bulk Emails using an Excel Sheet
- **URL:** `/email/schedule/bulk`
- **Method:** `POST`
- **Headers:**
  - `Content-Type: multipart/form-data`
- **Request Body:**
  - **Key:** `file`
    - Upload an Excel file containing the following columns:
      - `to`: Recipient email address
      - `subject`: Email subject
      - `body`: Email body
- **Response:**
  - **Success (200):**
    ```json
    {
      "message": "Bulk emails scheduled successfully"
    }
    ```
  - **Error (400):**
    ```json
    {
      "message": "Failed to process the Excel file"
    }
    ```

### 3. Schedule a Single Follow-Up Email
- **URL:** `/email/schedule/followup`
- **Method:** `POST`
- **Headers:**
  - `Content-Type: application/json`
- **Request Body:**
  ```json
  {
    "to": "recipient@example.com",
    "subject": "Follow-Up Email",
    "body": "This is a follow-up email.",
    "scheduledTime": "2024-12-31T10:00:00"
  }
  ```
- **Response:**
  - **Success (200):**
    ```json
    {
      "message": "Follow-up email scheduled successfully"
    }
    ```
  - **Error (400):**
    ```json
    {
      "message": "Invalid scheduling request"
    }
    ```

### 4. Schedule Bulk Follow-Up Emails using an Excel Sheet
- **URL:** `/email/schedule/followup/bulk`
- **Method:** `POST`
- **Headers:**
  - `Content-Type: multipart/form-data`
- **Request Body:**
  - **Key:** `file`
    - Upload an Excel file containing the following columns:
      - `to`: Recipient email address
      - `subject`: Email subject
      - `body`: Email body
      - `scheduledTime`: Time to send the follow-up email (in ISO format, e.g., `2024-12-31T10:00:00`)
- **Response:**
  - **Success (200):**
    ```json
    {
      "message": "Bulk follow-up emails scheduled successfully"
    }
    ```
  - **Error (400):**
    ```json
    {
      "message": "Failed to process the Excel file"
    }
    ```
### 5. List and graph of Emails Sent to a Particular Company
#### i) List of emails
- **URL** `/emails/list/{CompanyName}`
- **Method** `POST`
- **Request Body:**
  ```json
  {
      "CompanyName":"Name of company"
  }
  ```
- **Response**
-  - **Success (200):**
    ```json
    {
      "emails":[
        {
         "dateTime": "Date and time at which email was sent",
         "subject": "Subject of the email",
         "status": "Delivered/Undelivered"
        },
        { "dateTime": "Date and time at which email was sent",
         "subject": "Subject of the email",
         "status": "Delivered/Undelivered"
        }
       ]
    }
    ```
  - **Error (400):**
    ```json
    {
      "message": "Invalid Comapny name"
    }
    ```
#### ii) Graph of emails sent per company
- **URL** `/emails/graph/{CompanyName}`
- **Method** `POST`
- **Request Body:**
  ```json
  {
      "CompanyName":"Name of the company"
  }
  ```
- **Response:**
   -**Success (200):**
    ```json
    {
      "graph":{
          "labels":["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]
  }
           "numberOfEmails":[number of emails sent per month]
    }
    ```
    -**Error (400):**
      ```json
     {
      "message": "Invalid Comapny name"
     }
     ```
### 6. List and graph of Follow-up Emails Sent to a Particular Company
#### i) List of Follow-up emails
- **URL** `/followup/emails/list/{CompanyName}`
- **Method** `POST`
- **Request Body:**
  ```json
  {
      "CompanyName":"Name of company"
  }
  ```
  - **Response**
-  - **Success (200):**
    ```json
    {
      "emails":[
        {
         "dateTime": "Date and time at which follow up email was sent",
         "subject": "Subject of the follow up email",
         "status": "Delivered/Undelivered"
        },
        { "dateTime": "Date and time at which follow up email was sent",
         "subject": "Subject of the follow up email",
         "status": "Delivered/Undelivered"
        }
    ]
    }
    ```
   -**Error (400):**
      ```json
     {
      "message": "Invalid Comapny name"
     }
     ```  
   #### ii) Graph of emails sent per company
- **URL** `/followup/emails/graph/{CompanyName}`
- **Method** `POST`
- **Request Body:**
  ```json
  {
      "CompanyName":"Name of the company"
  }
  ```
- **Response:**
   -**Success (200):**
    ```json
    {
      "graph":{
          "labels":["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]
  }
           "numberOfEmails":[number of Follow-up emails sent per month]
    }
    ```
    -**Error (400):**
      ```json
     {
      "message": "Invalid Comapny name"
     }
     ```

       
## Json files for GET

### 1). Total Follow-up Emails sent
- **URL:** `/followup-emails/sent`
- **Method:** `GET`
- **Response:**
  - **Success (200):**
  ```json
   {
    "TotalSent": "No. of emails sent"
  }
  ```
### 2). Total Follow-up Emails scheduled to be sent
- **URL:** `/followup-emails/scheduled`
- **Method:** `GET`
- **Response:**
  - **Success (200):**
  ```json
   {
    "TotalScheduled": "No. of emails scheduled"
  }
  ```
### 3). Total Follow-up Emails failed
- **URL:** `/followup-emails/failed`
- **Method:** `GET`
- **Response:**
  - **Success (200):**
  ```json
   {
    "FailedEmails": "No. of emails failed"
  }
  ```
### 4).  Graph of Follow-up Emails sent in -
#### i) last Week
- **URL:** `/followup-emails/graph/lastWeek`
- **Method:** `GET`
- **Response:**
  - **Success (200):**
  ```json
   {
    "values": [],
    "labels": ["Mon","Tue","Wed","Thu","Fri","Sat","Sun"]
  }
  ```
#### ii) last Month
- **URL:** `/followup-emails/graph/lastMonth`
- **Method:** `GET`
- **Response:**
  - **Success (200):**
  ```json
   {
    "values": [],
    "labels":["Week 1","Week 2","Week 3","Week 4"]
  }
  ```
#### ii) last Year
- **URL:** `/followup-emails/graph/lastYear`
- **Method:** `GET`
- **Response:**
  - **Success (200):**
  ```json
   {
    "values": [],
    "labels":["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]
  }
  ```
### 5). Total Emails sent
- **URL:** `/dashboard/sent`
- **Method:** `GET`
- **Response:**
  - **Success (200):**
  ```json
   {
    "TotalSent": "No. of total emails sent"
  }
  ```
### 6). Total Emails scheduled to be sent
- **URL:** `/dashboard/scheduled`
- **Method:** `GET`
- **Response:**
  - **Success (200):**
  ```json
   {
    "TotalScheduled": "No. of total emails scheduled to be sent"
  }
  ```
### 7). Total Failed Emails
- **URL:** `/dashboard/failed`
- **Method:** `GET`
- **Response:**
  - **Success (200):**
  ```json
   {
    "TotalFailed": "No. of total failed emails"
  }
  ```
  ### 8. Graphs of Emails sent in-
  #### i) last week
  - **URL** `/emails/graph/lastweek`
  - **Method** `GET`
  - **Response**
     **Success (200)**
     ```json
     {
     "values": [],
     "labels":["Mon","Tue","Wed","Thu","Fri","Sat","Sun"]
     }
     ```
  #### ii) last month
  - **URL** `/emails/graph/lastmonth`
  - **Method** `GET`
  - **Response**
     **Success (200)**
       ```json
       {
         "values":[],
         "labels":["Week 1","Week 2","Week 3","Week 4"]
       }
       ```
  #### iii) last year
  - **URL** `/emails/graph/lastyear`
  - **Method** `GET`
  - **Response**
     **Success (200)**
       ```json
       {
         "values":[],
          "labels":["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]
       }
       ```
## Additional Details

### 1. Excel File Format
- The Excel file for bulk email scheduling should follow this structure:

| to                  | subject           | body                      | scheduledTime         |
|---------------------|-------------------|---------------------------|-----------------------|
| recipient1@example.com | Test Email 1     | This is email 1.          | (Optional for bulk emails) |
| recipient2@example.com | Follow-Up Email  | This is follow-up email.  | 2024-12-31T10:00:00  |

### 2. Scheduling Logic
- Emails can be scheduled at a specific time using the `scheduledTime` parameter.
- If `scheduledTime` is omitted for bulk emails, they will be sent immediately.

### 3. Error Handling
- All endpoints return appropriate error messages for invalid input or processing failures.
- Example:
  ```json
  {
    "message": "Invalid email address"
  }
  ```

---

## Setup Instructions

### Prerequisites
- Java 17+
- Spring Boot 3.x
- Maven
- SMTP credentials (e.g., Gmail or any SMTP provider)
