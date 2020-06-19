define({ "api": [
  {
    "group": "Users",
    "version": "0.0.1",
    "description": "<p>Delete service</p>",
    "type": "delete",
    "url": "users/:id",
    "title": "<5>delete",
    "permission": [
      {
        "name": "none"
      }
    ],
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "number/1",
            "optional": false,
            "field": "id",
            "description": "<p>Id</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "HTTP/1.1 200 OK",
          "content": "{\n\t\"timestamp\": \"02-10-2020  00:04:00 a. m.\",\n\t\"status\": 200,\n\t\"data\": [\n\t\t{\n\t\t\t\"id\": 1\n\t\t}\n\t]\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "HTTP/1.1 400 Bad Request",
          "content": "{\n\t\"timestamp\": \"2020-01-03T16:42:13.727+0000\",\n\t\"status\": 400,\n\t\"error\": \"BAD_REQUEST\",\n\t\"message\": \"your problem message\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 500 Internal Server Error",
          "content": "{\n\t\"timestamp\": \"2020-01-03T17:37:02.348+0000\",\n\t\"status\": 500,\n\t\"error\": \"Internal Server Error\",\n\t\"message\": \"your error message\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "C:/Develop/Pechblenda/polonium/polonium-incidence-rest/src/main/kotlin/org/pechblenda/polonium/controller/UserController.kt",
    "groupTitle": "Users",
    "name": "DeleteUsersId"
  },
  {
    "group": "Users",
    "version": "0.0.1",
    "description": "<p>Get all service</p>",
    "type": "get",
    "url": "users",
    "title": "<1>get-all",
    "permission": [
      {
        "name": "none"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "HTTP/1.1 200 OK",
          "content": "\t\t{\n\t\t\t\"timestamp\": \"02-10-2020  00:04:00 a. m.\",\n\t\t\t\"status\": 200,\n\t\t\t\"data\": [\n\t\t\t\t{\n      \t\t\"id\": 1\n      \t}\n\t\t\t]\n\t\t}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "HTTP/1.1 400 Bad Request",
          "content": "{\n\t\"timestamp\": \"2020-01-03T16:42:13.727+0000\",\n\t\"status\": 400,\n\t\"error\": \"BAD_REQUEST\",\n\t\"message\": \"your problem message\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 500 Internal Server Error",
          "content": "{\n\t\"timestamp\": \"2020-01-03T17:37:02.348+0000\",\n\t\"status\": 500,\n\t\"error\": \"Internal Server Error\",\n\t\"message\": \"your error message\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "C:/Develop/Pechblenda/polonium/polonium-incidence-rest/src/main/kotlin/org/pechblenda/polonium/controller/UserController.kt",
    "groupTitle": "Users",
    "name": "GetUsers"
  },
  {
    "group": "Users",
    "version": "0.0.1",
    "description": "<p>Get by id service</p>",
    "type": "get",
    "url": "users/:id",
    "title": "<2>get",
    "permission": [
      {
        "name": "none"
      }
    ],
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "number/1",
            "optional": false,
            "field": "id",
            "description": "<p>Id</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "HTTP/1.1 200 OK",
          "content": "{\n\t\"timestamp\": \"02-10-2020  00:04:00 a. m.\",\n\t\"status\": 200,\n\t\"data\": {\n\t\t\"id\": 1\n\t}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "HTTP/1.1 400 Bad Request",
          "content": "{\n\t\"timestamp\": \"2020-01-03T16:42:13.727+0000\",\n\t\"status\": 400,\n\t\"error\": \"BAD_REQUEST\",\n\t\"message\": \"your problem message\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 500 Internal Server Error",
          "content": "{\n\t\"timestamp\": \"2020-01-03T17:37:02.348+0000\",\n\t\"status\": 500,\n\t\"error\": \"Internal Server Error\",\n\t\"message\": \"your error message\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "C:/Develop/Pechblenda/polonium/polonium-incidence-rest/src/main/kotlin/org/pechblenda/polonium/controller/UserController.kt",
    "groupTitle": "Users",
    "name": "GetUsersId"
  },
  {
    "group": "Users",
    "version": "0.0.1",
    "description": "<p>Create service</p>",
    "type": "post",
    "url": "users",
    "title": "<3>create",
    "permission": [
      {
        "name": "none"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Request-Body:",
          "content": "{\n\t\"id\": 1\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "HTTP/1.1 200 OK",
          "content": "{\n\t\"timestamp\": \"2020-01-13T17:25:00.963+0000\",\n\t\"status\": 200,\n\t\"data\": {\n\t\t\"id\": 1\n\t}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "HTTP/1.1 400 Bad Request",
          "content": "{\n\t\"timestamp\": \"2020-01-03T16:42:13.727+0000\",\n\t\"status\": 400,\n\t\"error\": \"BAD_REQUEST\",\n\t\"message\": \"your problem message\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 500 Internal Server Error",
          "content": "{\n\t\"timestamp\": \"2020-01-03T17:37:02.348+0000\",\n\t\"status\": 500,\n\t\"error\": \"Internal Server Error\",\n\t\"message\": \"your error message\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "C:/Develop/Pechblenda/polonium/polonium-incidence-rest/src/main/kotlin/org/pechblenda/polonium/controller/UserController.kt",
    "groupTitle": "Users",
    "name": "PostUsers"
  },
  {
    "group": "Users",
    "version": "0.0.1",
    "description": "<p>Update service</p>",
    "type": "put",
    "url": "users",
    "title": "<4>update",
    "permission": [
      {
        "name": "none"
      }
    ],
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "number/1",
            "optional": false,
            "field": "id",
            "description": "<p>Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Body:",
          "content": "{\n\t\"id\": 1\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "HTTP/1.1 200 OK",
          "content": "{\n\t\"timestamp\": \"2020-01-13T17:25:00.963+0000\",\n\t\"status\": 200,\n\t\"data\":  {\n\t\t\"id\": 1\n\t}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "HTTP/1.1 400 Bad Request",
          "content": "{\n\t\"timestamp\": \"2020-01-03T16:42:13.727+0000\",\n\t\"status\": 400,\n\t\"error\": \"BAD_REQUEST\",\n\t\"message\": \"your problem message\"\n}",
          "type": "json"
        },
        {
          "title": "HTTP/1.1 500 Internal Server Error",
          "content": "{\n\t\"timestamp\": \"2020-01-03T17:37:02.348+0000\",\n\t\"status\": 500,\n\t\"error\": \"Internal Server Error\",\n\t\"message\": \"your error message\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "C:/Develop/Pechblenda/polonium/polonium-incidence-rest/src/main/kotlin/org/pechblenda/polonium/controller/UserController.kt",
    "groupTitle": "Users",
    "name": "PutUsers"
  }
] });
