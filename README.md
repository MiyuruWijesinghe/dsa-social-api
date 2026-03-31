# 🚀 DSA Social API (Spring Boot)

A backend project that demonstrates **Data Structures & Algorithms using real-world REST APIs**.

---

## Think of it like this:

| DSA Concept | Real API Feature |
|--------|------------|
| Array / List | JSON collections (GET /users) |
| HashMap | Fast lookup (GET /users/{id}) |
| Stack | Undo / history |
| Queue | Job processing / requests |
| Linked List | Feed / timeline |
| Tree | Comments / categories |
| Graph | Followers / recommendations |
| Sorting | ?sort=asc |
| Searching | ?search=name |

---

## 🧠 Concepts Covered

| Feature | DSA Concept |
|--------|------------|
| Users API | HashMap (O(1)) |
| Posts API | ArrayList + Sorting |
| Comments | Tree (Recursion) |
| Undo Feature | Stack |
| Job Queue | Queue |
| Followers | Graph |

---

## ⚙️ Tech Stack

- Java 8
- Spring Boot
- REST APIs
- In-Memory Storage (No DB)

---

## ▶️ Run the Project

```bash
mvn spring-boot:run
```

---

## 🔥 API Endpoints

### Create User
POST /users

### Get User
GET /users/{id}

### Create Post
POST /posts

### Get Posts (Sorted)
GET /posts?sort=likes

---

## 💡 Why This Project?

This project is designed to:

- Learn DSA in a practical way
- Understand backend internals
- Build interview-ready skills

---

## 🚀 Future Improvements

- LRU Cache
- Rate Limiter
- Pagination
- Graph-based recommendations

---

## ⭐ If you like this project

Give it a star and follow for more!
