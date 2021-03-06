Labs
====

Labs is a lightweight CMS for blog and idea management for businesses.

Features
========

Labs is a tailor-made solution for businesses who want to use blog posts to communicate with their customers, and collect their customers' ideas.

Features includes:

* Let admins create blog posts, twitter quotes and ideas.
* Let users comment on blog posts.
* Let users contribute ideas.
* Let users comment on ideas.
* Let users vote for ideas.
* Let users share content on Twitter, Facebook and Google+.

Technologies used
=================

Labs is a single page js app with a Scalatra backend with MongoDb.

### Frontend

* [dispatch.js](https://github.com/olav/dispatch.js) for routing
* [scene.js](https://github.com/olav/scene.js) for view model rendering
* [underscore.js](http://underscorejs.org/) for templating

### Backend

* [Scalatra](http://scalatra.org/) for web api
* [MongoDB](http://www.mongodb.org/) for data storage
* [json4s](https://github.com/json4s/json4s) and jackson for json support

Demo
====

[Digipost Labs](https://labs.digipost.no)

Install
=======

### Clone repository

    $ git clone https://github.com/digipost/labs.git

### Backend

Install and run MongoDB:

    $ cd labs/backend
    $ sudo apt-get install mongodb
    $ sudo mkdir -p /data/db
    $ sudo chown $USER /data/db
    $ mongod

Start the mongo shell and create the required collections:

    $ /usr/bin/mongo
    > show dbs
    local   0.078125GB
    > use labs
    switched to db labs
    > db.users.save({})
    > db.sessions.save({})
    > db.items.save({})
    > show dbs
    labs    0.203125GB
    local   0.078125GB

Create a dummy secret.conf file:

    $ echo "labs {
        oauth {
            clientId = "OAUTH_ID_FROM_DIGIPOST"
            secret = "SECRET"
        }
    }" > secret.conf

Start the backend:

    $ ./sbt
    > run

### Frontend

The dependencies are already included in the repository, but you can update to newer versions with bower if necessary:

    $ cd ../frontend
    $ sudo apt-get install nodejs nodejs-dev npm
    $ sudo npm install -g bower
    $ ./bower

Get Pacbot and fire up the frontend:

    $ sudo npm install -g pacbot
    $ pacbot -d

### Startup script

We have supplied a startup script for development purposes. It starts a multi window screen with nodeproxy, mogodb, frontend and backend at the same time.
Before running the script for the first time, you need to install node.js and npm, run the setup script to install npm packages, and edit the mongod.conf file to fit your db needs. The setup.sh script will promt for sudo password.

Prepare the script dependencies:

    $ cd labs/script
    $ sudo apt-get install nodejs nodejs-dev npm
    $ ./setup.sh
	
Run the script:

    $ ./run

Direct your browser to https://localhost:7000/


Enjoy!

License
=======

Apache License, Version 2.0
https://www.apache.org/licenses/LICENSE-2.0

Images and logos for Posten and Digipost is (C) Posten Norge AS and not licensed under Apache License, Version 2.0.
