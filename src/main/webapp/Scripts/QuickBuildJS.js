function confirmFunction() {
    alert("Forespørgsel er nu sendt til Fog. Tak for din henvendelse");
}

function findInquiries(cosEmail) {
    var email = cosEmail;

    window.open("/Fog/FrontController?command=inquiry&customer=" + email, "nameofwindow", "directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=1600,height=600");
}

// Adds angle option, when rejsning is chosen in the dropdown.
$('select[name=roofType]').on('change', function () {
    if (this.value === "rejsning") {
        document.getElementById("angle").style.display = "block";
    }else{
        document.getElementById("angle").style.display = "none";
    }
});


$('input[name=shackCheckbox]').on('change', function () {
    if ($(this).is(':checked')) {
        document.getElementById("shackLength").style.display = "block";
        document.getElementById("shackHeight").style.display = "block";
    }else {
        document.getElementById("shackLength").style.display = "none";
        document.getElementById("shackHeight").style.display = "none";
    }
});


