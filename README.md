# 📌 Pinterest Web Testing Project

A QA testing project that automates and manually tests key user workflows on [Pinterest.com](https://www.pinterest.com), including login, signup, pin interactions, and settings management. Built using Java, Selenium WebDriver, and TestNG.

---

## ✅ Features Tested

- 🔐 Login and Sign-up
- ✏️ Profile Editing
- 📌 Save, Like, and Upload Pins
- 🔍 Keyword Search and Visual Search
- 🗂️ Create Boards
- 🌐 Language Switching
- 📱 Manual tests for responsiveness and user preferences

---

## 🛠️ Tech Stack

- **Language**: Java
- **Automation Tools**: Selenium WebDriver, TestNG
- **Browser**: Chrome (ChromeDriver)
- **IDE**: IntelliJ IDEA
- **Others**: WebDriverWait, JavaScriptExecutor

---

## 🚀 How to Run

1. Clone the repository.
2. Open in IntelliJ or Eclipse.
3. Make sure ChromeDriver is installed and configured.
4. Replace values in `TestData.java` with valid credentials.
5. Run individual test methods or configure a TestNG suite.

---


---

## 🧪 Automated Test Methods

| Method Name                          | Description                               |
|-------------------------------------|-------------------------------------------|
| `signUp()`                          | Automates account registration            |
| `login()`                           | Logs in with valid credentials            |
| `forgotPassword()`                  | Sends a password reset request            |
| `clickRandomPinterestElement()`     | Opens a random pin                        |
| `clickSaveButton()`                 | Saves a pin to a board                    |
| `verifySearchReturnsRelevantResults()` | Validates relevant search output        |
| `newBoard()`                        | Creates a user board                      |
| `upLoadPin()`                       | Uploads an image and publishes a pin      |
| `profileInformation()`             | Edits profile names                       |
| `VisualSearch()`                    | Tests "Shop the Look" feature             |
| `likePin()`                         | Likes/reacts to a pin                     |
| `changeLanguageToArabicAndVerify()` | Changes language and checks `lang` attr   |

---

## 👀 Manual Tests

- 🛍️ Shopping Pins redirect correctly
- 📱 Mobile responsiveness on Chrome DevTools
- 🔒 Privacy and notification preferences
- 💬 Posting and displaying comments

---

## ✅ Results Summary

| Test Type  | Total | Passed | Failed |
|------------|-------|--------|--------|
| Automated  | 11    | ✅ 11   | ❌ 0   |
| Manual     | 4     | ✅ 4    | ❌ 0   |

---

## 📈 Future Enhancements

- 📱 Add Appium for mobile device automation
- 📊 Generate HTML reports with Allure or ExtentReports
- 🔁 Add data-driven testing with CSV or JSON
- 🔍 Visual regression testing with Applitools or Percy

---

## ⚠️ Disclaimer

This project is for educational/demo purposes only and is not affiliated with Pinterest.




