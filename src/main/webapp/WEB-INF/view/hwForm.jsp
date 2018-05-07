<html>
<head>
<title>Hello World!</title>
</head>

<body>
<h2>Detail input</h2>

    <!-- Specify the tag to be used as the next point in things .../processForm/..  It is a tag and NOT a function name -->
    <!-- One assumes the controller is meant to find the "tag" and ACTION/method linked to a useful call -->
    <form action ="processForm" method="GET">

        <!-- The stuff entered here gets captured and passed via URL as ?theName=<value> -->
        <input type="text"  name="theName" placeholder="Who are you?"/>

        <!-- The submit button/option presumably grabs the parameter(s) and kicks ofd the move (dictated by form action, above) -->
        <input type="submit"/>
    </form>
</body>

</html>