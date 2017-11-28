function confirmFunction() {
    alert("Forespørgsel er nu sendt til Fog. Tak for din henvendelse");
}

function findInquiries(cosEmail) {
    var email = cosEmail;
    
    window.open("/Fog/FrontController?command=inquiry&customer="+email,"nameofwindow","directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=1600,height=600");
}



function sortTable(idTable, sortIndex) {
  var table, rows, switching, i, x, y, shouldSwitch, ascOrDesc;
  
  table = document.getElementById(idTable);
  ascOrDesc = document.getElementsByClassName("ascdesc")[sortIndex].value;

  switching = true;
  /* Make a loop that will continue until
  no switching has been done: */
  while (switching) {
    // Start by saying: no switching is done:
    switching = false; 
    rows = table.getElementsByTagName("tr");
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < (rows.length - 1); i++) {
        // Start by saying there should be no switching:
        shouldSwitch = false;
        /* Get the two elements you want to compare,
        one from current row and one from the next: */
        x = rows[i].getElementsByTagName("td")[sortIndex];
        y = rows[i + 1].getElementsByTagName("td")[sortIndex];
        // Check if the two rows should switch place:


        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase() && ascOrDesc === "asc") {
            // I so, mark as a switch and break the loop:
            shouldSwitch= true;
            break;
        } else if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase() && ascOrDesc === "desc"){
            // I so, mark as a switch and break the loop:
            shouldSwitch= true;
            break;
        }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
  
  if (ascOrDesc === "asc") document.getElementsByClassName("ascdesc")[sortIndex].value = "desc";
  else document.getElementsByClassName("ascdesc")[sortIndex].value = "asc";
}