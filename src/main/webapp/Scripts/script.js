/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function findInquiryByEmailAndId(cosEmail,inqId) {
    var email = cosEmail;
    var id = inqId;
    
    window.open("/Fog/FrontController?command=inquiry&customer="+email+"&id="+id,"nameofwindow","directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=1600,height=600");
}

function findInquiriesByEmail(cosEmail) {
    var email = cosEmail;
    
    window.location.replace("/Fog/FrontController?command=viewinquiries&email="+email);
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

function rowTextSearch(searchbar, tableId, index) {
    var input, filter, table, tr, td, i;
    input = searchbar;
    filter = input.value.toUpperCase();
    table = document.getElementById(tableId);
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[index];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }       
    }
}

function rowTextSearch(searchbar, tableId, index) {
    var input, filter, table, tr, td, i;
    input = searchbar;
    filter = input.value.toUpperCase();
    table = document.getElementById(tableId);
    tr = table.getElementsByTagName("tr");
    
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[index];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }       
    }
}

function rowSorting(tableId) {
    var inputs, filter, table, tr, td, i, notmatch;

    table = document.getElementById(tableId);
    tr = table.getElementsByTagName("tr");
    
    notmatch = false;
    
    inputs = document.getElementsByClassName("searchbar");
    
    for (i = 0; i < tr.length; i++) {
        for (var j = 0; j < inputs.length; j++) {
            td = tr[i].getElementsByTagName("td")[j];
            if (td) {
                filter = inputs[j].value.toUpperCase();
                
                if (!(td.innerHTML.toUpperCase().indexOf(filter) > -1)) {
                    notmatch = true;
                } 
            }
        }
        if (notmatch) tr[i].style.display = "none";
        else if (!notmatch) tr[i].style.display = "";
        
        notmatch = false;
    }
}

rowSorting("customertable");
