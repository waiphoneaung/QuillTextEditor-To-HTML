# Quill Editor Spring Boot Application

## Description

This project is a Spring Boot application that integrates the Quill rich text editor to create, edit, and manage posts. The edited content is saved as HTML files and managed within the application. 

## Features

- Create new posts using Quill rich text editor.
- Edit existing posts.
- Save and load HTML content for posts.
- Delete posts and their associated HTML files.
- Consistent file path management.

## Technologies Used

- Java
- Spring Boot
- Thymeleaf
- Quill.js
- Bootstrap
- Maven

## Installation

1. **Clone the repository**

    ```sh
    git clone https://github.com/waiphoneaung/QuillTextEditor-To-HTML.git
    cd QuillTextEditor-To-HTML
    ```

2. **Build the project**

    ```sh
    mvn clean install
    ```

3. **Run the application**

    ```sh
    mvn spring-boot:run
    ```

4. **Access the application**

    Open your web browser and go to `http://localhost:8080`

## Usage

### Creating a New Post

1. Go to the create post page: `http://localhost:8080/create`
2. Enter the title and content using the Quill editor.
3. Click "Save" to save the post. The content will be saved as an HTML file.

### Editing an Existing Post

1. On the main page (`http://localhost:8080`), click the "Edit" button next to the post you want to edit.
2. Modify the title or content using the Quill editor.
3. Click "Save" to update the post. The changes will overwrite the existing HTML file.

### Deleting a Post

1. On the main page (`http://localhost:8080`), click the "Delete" button next to the post you want to delete.
2. The post and its associated HTML file will be deleted.

## Project Structure

- **src/main/java**: Contains the Java source files
    - **com.quill.test.controller**: Controllers for handling web requests
    - **com.quill.test.model**: Entity classes
    - **com.quill.test.repository**: JPA repositories
    - **com.quill.test.service**: Service classes for business logic
    - **com.quill.test.util**: Utility classes

- **src/main/resources**: Contains static resources and templates
    - **templates**: Thymeleaf templates
    - **static/html**: Directory for saved HTML files

## Contributing

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`
3. Make your changes and commit them: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature-name`
5. Submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Quill.js](https://quilljs.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Bootstrap](https://getbootstrap.com/)
