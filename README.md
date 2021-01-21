# Проекты компании

Дать возможность собирать информацию о проектах компании и людей на проектах. Предоставлять историю работы человека над проектами и используемыми им технологиями. Предоставить возможность подбора людей на новый проект.

## User Stories

- [x] User can view available companies and choose a company, so he can know information about company and go to a company page
  - [x] Main page contains companies list
  - [x] Each company is selectable
  - [x] After selecting company route changes to /company/:ID, so we are at company page

### Company Page

- [ ] User can view company projects and choose a project, so he can go to a project page
  - [ ] Company page contains company name and projects list
  - [ ] Each project is selectable
  - [ ] After selecting a project route changes to /project/:ID, so we are at project page
  - [ ] Request: GET /company/ID/projects returns light variant of company's project (consists of project ID and Name)

### Company Project Page

- [ ] User can see details of current project, so he can get more information
  - [ ] There is a list of technoligies required by this project
  - [ ] There is list of people which are current working with this project
  - [ ] Each person in this list is clickable
  - [ ] When I click on any person, route changes to /people/:ID so we are at person page
- [ ] User can click 'Suggest People', so the list of suitable for this project people appears
  - [ ] System looks through database for people that know required technologies by projects but not working on current project

### Person Page

- [ ] User can view details of person so he can get an information
  - [ ] Person name
  - [ ] Familiar technologies
  - [ ] Projects history
    - [ ] Contains clickable project name
      - [ ] When user clicks route changes to /project/:ID
    - [ ] Contains period when this person worked at this project
      - E.g. ``15.01.2002 - 22.02.2021``
