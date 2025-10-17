## Задание: 
1. Создайте Spring приложение для управления задачами (Task Management). Примените паттерн Singleton для создания сервиса управления задачами. 
2. Реализуйте паттерн Observer для отслеживания изменений в состоянии задач и оповещения об этих изменениях подписчиков.
3. Используйте паттерн фабрики (Factory Method) для создания разных типов задач (например, задачи срочного и обычного выполнения).


## Project Structure:
### src/main/java/com.example.taskmanager
    TaskManagerApplication.java
    controller
        TaskController.java
    model
        Task.java
        UrgentTask.java
        RegularTask.java
    factory
        TaskFactory.java
        UrgentTaskFactory.java
        RegularTaskFactory.java
    observer
        TaskObserver.java
        TaskLogger.java
    repository
        TaskRepository.java
    service
        TaskService.java
