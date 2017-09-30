:: Start mongod
mongod

:: connect with mongo, create expected db and collection
mongo --eval "db.getSiblingDB('quickpost-dev').createCollection('messages')"

echo "Done!"