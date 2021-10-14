# Coding challenge

Completed

I have created a microservice using Gradle.

5 Entry points for managing individual entities.

On every Entity " Course, Subject, Lesson, Tag, Video" all crud operations can be performed by Instructor and not by students. If a student tries to do an activity,
permission denied exception will be thrown.

For the deletion part- I have used soft delete methodology

DB- MongoDB

Whenever Instructor/Student fetches the detail of video or course - view count will increase by 1. The instructor can also see the analytics of videos and courses - the result will be a list of items sorted in descending order on the basis of views.

Architecture - I have followed the hexagonal architecture

Entry points<---> Service  <---> Data provider

Domain



To-Do- Unit test cases More enhancement of domain
