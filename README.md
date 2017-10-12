# Sam Soper Individual Project - ChoreTracker

### Problem Statement
For over 8 years, my wife and I have relied on various self-organization and
communication tactics to satisfactorily distribute domestic tasks in a mutually
beneficial way.  Sometimes we come close to figuring it out, but for the most 
part - we've failed.  Our current solution is a Kanban board that is tacked up
to a wall in our kitchen. A Kanban board is divided into three columns: to do, 
doing, and done. You move a sticky note with a task written on it through each 
category until it's finished.  This keeps each person in our household aware 
of what tasks need doing, who is working on them, and what its status is. The
board works some of the time, but as soon as we have a busy week, we forget to 
look at the board and some tasks tend to slip through the cracks.  More 
information on Kanban below:  

* Kanban Board : https://en.wikipedia.org/wiki/Kanban_board

The major drawback of the board is that it is not mobile and thus it is 
unavailable to us when we're away. This is inconvenient for tasks that need to 
be done outside the household.  Out of sight, out of mind.  It would great
to receive periodic notifications on our phones to remind us of chores we
need to do and errands we need to run.  It would also be nice to see when
a person in a household creates or completes a task so that it can be started
on the fly - or avoided to eliminate duplication of effort.

I would like to create an application that makes use of Google's calendar API 
and perhaps a text messaging API to notify users when household chores are 
assigned and when they're completed.  This way, members in a household don't
have to remember to do their chores - the chore application reminds them
automatically.

### Project Technologies/Techniques 

* Security/Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: submit chores to be tracked
  * All: You must be logged in to view ChoreTracker content
* Database (MySQL and Hibernate)
  * Store users and roles
  * Store ChoreTracker information
* Web Services or APIs
  * Amazon Simple Notification Service or something similar for notifying users to do their chores
* Amazon Simple Notification Service or something similar(independent research topic)
* Logging
  * Configurable logging using Log4J. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Site and database hosted on AWS
* Unit Testing
  * JUnit tests to achieve 80% code coverage 

### Design

* [Screen Design](DesignDocuments/wireframes/ChoreTracker_wireframes1.png)
* [Application Flow](DesignDocuments/applicationFlow.md)
* [Database Design](DesignDocuments/databaseDesign.png)

### [Project Plan](ProjectPlan.md)

### [Time Log](TimeLog.md) 
### [Journal](Journal.md)


