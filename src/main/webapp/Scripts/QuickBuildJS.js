function confirmFunction() {
    alert("Forespørgsel er nu sendt til Fog. Tak for din henvendelse");
}

function findInquiries(cosEmail) {
    var email = cosEmail;
    
    window.open("/Fog/FrontController?command=inquiry&customer="+email,"nameofwindow","directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=1600,height=600");
}