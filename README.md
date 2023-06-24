# securitymodel
A parser from JSON representation to Java object of Security model

```
<dependency>
  <groupId>io.github.modelsvgu</groupId>
  <artifactId>securitymodelj</artifactId>
  <version>[1.0.0,)</version>
</dependency>
```

Current support includes:
- Actions: READ
- Resources: Attributes, associations
- Constraints: OCL constraints, supported syntax can be found [here](https://github.com/MoDELSVGU/JavaOCL/blob/master/README.md).

Example:
```json
[
  {
    "roles": [
      "Admin"
    ],
    "actions": [
      "read"
    ],
    "resources": [
      {
        "entity": "Student",
        "attribute": "age"
      },
      {
        "association": "Enrollment"
      }
    ],
    "auth": [
      {
        "ocl": "true",
        "sql": "TRUE"
      }
    ]
  },
  {
    "roles": [
      "Lecturer"
    ],
    "actions": [
      "read"
    ],
    "resources": [
      {
        "entity": "Student",
        "attribute": "age"
      },
      {
        "association": "Enrollment"
      }
    ],
    "auth": [
      {
        "ocl": "Lecturer.allInstances()->select(l|l.age>caller.age)->isEmpty()",
        "sql": "EXISTS (SELECT 1 FROM Lecturer l1 WHERE l1.Lecturer_id = kcaller AND NOT EXISTS (SELECT 1 FROM Lecturer l2 WHERE l2.age > l1.age))"
      }
    ]
  },
  {
    "roles": [
      "Lecturer"
    ],
    "actions": [
      "read"
    ],
    "resources": [
      {
        "entity": "Lecturer",
        "attribute": "name"
      },
      {
        "entity": "Student",
        "attribute": "name"
      }
    ],
    "auth": [
      {
        "ocl": "true",
        "sql": "TRUE"
      }
    ]
  },
  {
    "roles": [
      "Lecturer"
    ],
    "actions": [
      "read"
    ],
    "resources": [
      {
        "association": "Enrollment"
      }
    ],
    "auth": [
      {
        "ocl": "kcaller.students->exists(s|s=kstudents)",
        "sql": "EXISTS (SELECT 1 FROM Enrollment WHERE lecturers = kcaller AND kstudents = students)"
      }
    ]
  },
  {
    "roles": [
      "Lecturer"
    ],
    "actions": [
      "read"
    ],
    "resources": [
      {
        "entity": "Lecturer",
        "attribute": "email"
      }
    ],
    "auth": [
      {
        "ocl": "kcaller = kself",
        "sql": "kcaller = kself"
      }
    ]
  },
  {
    "roles": [
      "Lecturer"
    ],
    "actions": [
      "read"
    ],
    "resources": [
      {
        "entity": "Student",
        "attribute": "email"
      },
      {
        "entity": "Student",
        "attribute": "age"
      }
    ],
    "auth": [
      {
        "ocl": "kcaller.students->exists(s|s = kself)",
        "sql": "EXISTS (SELECT 1 FROM Enrollment WHERE lecturers = kcaller AND kself = students)"
      }
    ]
  },
  {
    "roles": [
      "Lecturer"
    ],
    "actions": [
      "read"
    ],
    "resources": [
      {
        "entity": "Lecturer",
        "attribute": "email"
      }
    ],
    "auth": [
      {
        "ocl": "kcaller.students->exists(s|s.lecturers->exists(l|l=kself))",
        "sql": "EXISTS (SELECT 1 FROM Enrollment e1 JOIN Enrollment e2 ON e1.students = e2.students WHERE e1.lecturers = kcaller AND e2.lecturers = kself)"
      }
    ]
  },
  {
    "roles": [
      "Lecturer"
    ],
    "actions": [
      "read"
    ],
    "resources": [
      {
        "association": "Enrollment"
      }
    ],
    "auth": [
      {
        "ocl": "kcaller.students->exists(s|s.lecturers->exists(l|l=klecturers))",
        "sql": "EXISTS (SELECT 1 FROM Enrollment e1 JOIN Enrollment e2 ON e1.students = e2.students WHERE e1.lecturers = kcaller AND e2.lecturers = klecturers)"
      }
    ]
  }
] 
```
