<!DOCTYPE html>
<html lang="en">
<head>
    <title>Start Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Velkommen</h1>
    <form action='ReceiveUserNameFromDb' method='POST'>
        <label for = "uname">Email:</label>
        <input type = "text" id = "uname"/>
        <label for = "password">Passord:</label>
        <input type = "text" id = "password"/>
        <input type = "submit" />
    </form>

    <p>Click here to send a request for a user.
    <a href="RequestUserNameFromDb">get user</a></p>
</body>
</html>
