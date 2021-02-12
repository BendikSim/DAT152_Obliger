
// Used to toggle the menu on small screens when clicking on the menu button
function menuFunction() {
  var x = document.getElementById("mobileNav");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}

//Used to open car categories on CAR HIRE page
function openCategory(event, categoryName) {
  var i;
  var x = document.getElementsByClassName("category");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }

  categoryLinks = document.getElementsByClassName("categoryBtn");
  for (i = 0; i < categoryLinks.length; i++) {
    categoryLinks[i].className = categoryLinks[i].className.replace(" red-hover", "");
  }

  document.getElementById(categoryName).style.display = "block";
  event.currentTarget.className += " red-hover";
}