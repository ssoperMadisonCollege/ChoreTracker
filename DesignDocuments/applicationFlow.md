# Application Flow for ChoreTracker


### User Sign up

1. User chooses sign up on the menu (available on all pages, unless the user 
is signed in already).
1. User fills out the sign up form and submits.
1. Request goes to sign up servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition (show a message on the jsp)

### User Sign In

1. User chooses sign in on the menu (available on all pages, unless the user 
is signed in already).
1. User enters username and password on form and submits. 
1. If user is authenticated, the server will handle allowing access to edit 
pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### View Household chores

1. Page sends a request to view household chores servlet.
1. Servlet uses the household chores dao to display chores according to 
authentication/authorization criteria (who is signed in, what households
do they belong to, etc.)
1. Dao performs select and creates household chores object from results.
1. Dao returns household chores object matching criteria to servlet.
1. Servlet sends household chores list back to household chores jsp.
1. Household chores jsp displays the household chores.
1. Consider paging results so page does not get super long and too much data 
is sent.  However, hopefully the chore list isn't this long!

### View Chore

1. Page sends a request to view chore servlet along with criteria 
(chore, name, etc).
1. Servlet uses the chore dao to select chores according to criteria
1. Dao performs select and creates chore objects from results.
1. Dao returns list of chores matching criteria to servlet.
1. Servlet sends list back to chore  jsp.
1. chore jsp displays the chores.
1. Consider paging results so page does not get super long and too much data 
is sent.
1. NOTE: This page may not be necessary, or it might be best consolidated
into the View Household chores page.

### About

1. Static page - html only? 
1. Consider making contact info configurable.

### Add Chore to Household
1. Option only available to logged in users with proper role
1. User selects chore to add
1. User enters chore details
1. Details are sent to Add chore servlet
1. Servlet creates chore object
1. Servlet sends object to dao
1. Dao adds chore to the database (choreHousehold table)
1. Servlet sends confirmation to add chore to household page that chore 
has been added to the household successfully.

### Add Chore 
1. Option only available to logged in users with proper role
1. User enters chore  details
1. Details are sent to Add chore  servlet
1. Servlet creates chore  object
1. Servlet sends object to dao
1. Dao adds chore to the database
1. Servlet sends confirmation to chore page that chore has been added.








 