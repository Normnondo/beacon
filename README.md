# beacon
Problem statement - Currently many people set up their Warhammer games
on Facebook or other social media, and there's often a lot of back and forth
regarding exactly what the game is going to look like.  This application will
allow a user to set all their parameters when they're looking for a game, and
all a potential opponent will have to do is click 'Yes'.


First option - location? or game type?
Game type - 40k or AoS
40k 	- points
	- ITC style, narrative, campaign, radio buttons menu
	- painted, don't care, radio buttons
	- time use times on the half hour, radio buttons, or some other method, like Cozi uses?
	- location pre-load local stores, radio menu
	- date use calendar feature to make sure right day selected
	- proxies okay?

AoS	Same options?


Project plan - Welcome screen, search for available games.  
enter player info including zip code (goes into DB) 
use zip code to match with other players). 
Game setup screen, 
alert with match name and any message.

User stories?
1.       How do you normally set up a game?  Post on FB?  Messenger?  Text?  Phone call?  Other? 
Usually on FB on the MYCL page, more rarely on Messenger. - S. Hook
Text or Messenger. - P. Wisniewski
Face book and Text. - J. Miller

2.       How much back and forth do you feel you engage in?  1-2 questions?  4-5?  More?  
I usually just agree on points.  Many times say if I am doing narrative or competitive - but most of the people I play know I do more narrative. - S. Hook
Engagement depends on the type of game.  The more narrative, the more questions. - P. Wisniewski
3-4 questions. - J. Miller

3.       What sort of questions do you always want covered before you agree to a game?  Game type?  ITC vs. narrative?  Points?  Location?  Time/Date?  Particular army?  Scenario?  
Usually just when and where, usually decide on scenario once there. - S. Hook
Game type, points, location, time/date, (army only depends if we are trying a scenario). - P. Wisniewski
Are you free to play? What time? Where? Points? - J. Miller

4.       Anything else you like to know that helps you achieve a more enjoyable game?
Usually I try to choose my opponents that are looking for a similar game style, for me more theme or narrative driven. - S. Hook
Amount of time available to play, a fast I need to get this done during the week vs a weekend night where getting home at a reasonable hour isn't as important. The way things are done has changed over the years, I hate trying to organize a game over FB. - P. Wisniewski
Fun list? Hard List? Tourney practice list? - J. Miller

Project Plan:
    Determine how many classes will be needed on the back end to make these pages run.  
    Figure out a few issues like changing army selection based on game selected. 
    Build out database.
    Figure out my DAO and how to work with an API and if I'll need anything other 
    than a zip code API.   
    Deploy to web server.
    Put on finishing touches and test, test, test.

Class Plan -
	*Will need JSPs for:
		Welcome page
		Info Entry/Registration
		Setting up a game
		Checking available games
	Will need servlets for:
		Welcome page? (if operating like Adv Java project)
		Info Entry/Registration/Authentication (doable, or too much in one?)
		Setting up a game
		Checking available games
	*Will need a bean for:
		User info
		Game info
	*Will need a DAO for:
		User info
		Game info
	*Will need a SessionFactory for hibernate to connect to the database
	Will need a class to do the logic portion of matching up the current authenticated user 
		to the user who set up a game. This should also send a notification e-mail to 
		both users with the game information in it for reference. (Possibly a separate class?)
		Games should also disappear from the available list once they've been matched.
	May need a class to allow people to edit their game information, or at least delete and
		start over.  Might be able to do that in an existing class however.
		Also, should allow for someone to unmatch/cancel a game, allowing game to pop back up
		on the available list for someone else to select.

	* These are partially completed.
	
		