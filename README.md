
# Dear Participant,

I am glad that you have chosen my workshop :)

In order to verify the environment we will be working on during the workshop, I kindly ask you to make sure that you meet the tool requirements (*Requirements*).

## Useful links during the workshop:

- Notes:
  https://docs.google.com/document/d/1RqUe1DkDPB2K4awu-X7C8339D3F7fzcSs3kid5S84Uc/edit?usp=sharing

## Requirements

### Knowledge

I expect you to have:

- Basic knowledge of Java language and Maven projects;

- Basic understanding of Unix system;

- Familiarity with basic GIT concepts is preferred;

- Basic understanding of Selenium WebDriver library is desirable.

Unfortunately, due to the limited time of the workshop, there will be no time for a complete explanation of these concepts from scratch.

### Tools

Please bring your own computer Windows operating system. Unix machines are also fine, but not preferred. Please install:

- Selected IDE - preferably IntelliJ IDEA https://www.jetbrains.com/idea/ or Eclipse: https://www.eclipse.org/downloads/ If you choose Eclipse, please also install TestNG for Eclipse: https://marketplace.eclipse.org/content/testng-eclipse

- Java JDK - latest version -  http://www.oracle.com/technetwork/java/javase/downloads/

- GIT 
  - Windows: https://git-scm.com/download/win 
  **NOTE: During the installation, in the "Adjusting your PATH environment" window, select the option: "Use Git and optional Unix tools from the Windows Command Prompt" (the last radio button)"**
  - Linux: https://git-scm.com/download/linux
  - Mac: https://git-scm.com/download/mac

- Docker
  - Linux: https://docs.docker.com/install/linux/docker-ce/ubuntu/
  - Windows: https://docs.docker.com/docker-for-windows/install/
  - Mac: https://docs.docker.com/docker-for-mac/install/

- Docker Compose - installation required only for Linux computers: https://docs.docker.com/compose/install/

- Selenoid Installation Binary - https://github.com/aerokube/cm/releases 
  On Linux and Mac machines, add execution access to the downloaded binary: `chmod +x cm_linux_amd64` or `chmod +x ./cm_darwin_amd64`

- Latest versions of Chrome and FireFox browsers.

- If you do not have a GitHub account yet, please create one: https://github.com/join?source=header-home. After creating the account, go to https://forms.gle/q3DHGg2RLsN2c8247, provide the username, and submit the form.

## Environment verification

### Java

- Execute the following command in the console: `java -version`. Make sure that the information about the installed version of JAVA is displayed.

- Execute the following command in the console: `javac -version`. Make sure that the information about the installed version of the JAVA compiler is displayed.

### Git:

- Clone the repository `git clone https://github.com/tklepacki/nordic-testing-days.git`
- Go to the repository folder and make sure the project has been downloaded.
- For Windows systems only - go to the terminal (CMD) and execute the following command: `ls -al`
- Make sure that the files/folders of the given location are listed, and the command is recognized.

### IDE

- Import the Maven project in your IDE.

### Docker

- Execute the following command in the console: `docker -v`
- Make sure that the information about the installed version of Docker
- For Linux systems only - execute the following command:
  - `sudo groupadd docker`
  - `sudo usermod -aG docker $USER`
- Restart your machine

### Docker Compose

- Execute the following command in the console: `docker-compose -v`
- Make sure that information about the installed version of Docker Compose has been provided.

### Maven

- Enter the repository.
- Run the command `mvnw -v`. Make sure that information about the installed version of Maven has been provided.

## In case of any problems
Write to my email address: *t.klepacki@wp.pl*
