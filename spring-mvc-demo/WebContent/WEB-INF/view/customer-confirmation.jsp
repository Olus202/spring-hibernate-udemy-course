<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<head>
<title>Customer Confirmation</title>
</head>
<body>
Customer Confirmation: ${customer.firstName} ${customer.lastName}
<br><br>
Free Passes: ${customer.freePasses}

<br><br>
Postal Code: ${customer.postalCode}

<br><br>
Course Code: ${customer.courseCode}

</body>