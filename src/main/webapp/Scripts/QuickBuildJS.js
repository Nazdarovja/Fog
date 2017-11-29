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
    } else {
        document.getElementById("angle").style.display = "none";
    }
});

// Adds options to jsp after Calculate button
function check() {
    if (document.getElementById("shackCheckboxCheck").value === "on") {
        document.getElementById("shackCheckbox").checked = true;
        document.getElementById("shackLength").style.display = "block";
        document.getElementById("shackWidth").style.display = "block";
        $("#shackLengthInput").attr({
            "max": document.getElementById("length").value / 2,
            "min": 100
        });
        $("#shackWidthInput").attr({
            "max": document.getElementById("width").value,
            "min": 100
        });
    }
    if (document.getElementById("roofTypeCheck").value === "rejsning") {
        document.getElementById("angle").style.display = "block";
    }
}
check();

// Adds Length and Height visibilty to jsp
$('input[name=shackCheckbox]').on('change', function () {
    if ($(this).is(':checked')) {
        document.getElementById("shackLength").style.display = "block";
        document.getElementById("shackWidth").style.display = "block";
        document.getElementById("shackLength").required = true;
    } else {
        document.getElementById("shackLength").style.display = "none";
        document.getElementById("shackWidth").style.display = "none";
    }
});

$('select[name=length]').on('change', function () {
    $("#shackLengthInput").attr({
        "max": this.value / 2,
        "min": 100
    });
});
$('select[name=width]').on('change', function () {
        $("#shackWidthInput").attr({
        "max": this.value,
        "min": 100
    });
});