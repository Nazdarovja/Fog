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
        $("#angle").show();
    } else {
        $("#angle").hide();
    }
});

// Adds options to jsp after Calculate button
function check() {
    if (document.getElementById("shackCheckboxCheck").value === "on") {
        $("#shackCheckbox").attr("checked", true);
        $("#shackLength").show();
        $("#shackWidth").show();

        $("#shackLengthInput").attr("required", true);
        $("#shackWidthInput").attr("required", true);
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
        $("#angle").show();
    } else {
        $("#angle").hide();
    }
    if (document.getElementById("shackCheckboxCheck").value !== "on") {
        $("#shackLength").hide();
        $("#shackWidth").hide();
        $("#shackLengthInput").attr("value", null);
        $("#shackWidthInput").attr("value", null);
    }
}
check();

// Adds Length and Height visibilty to jsp
$('input[name=shackCheckbox]').on('change', function () {
    if ($(this).is(':checked')) {
        $("#shackLength").show();
        $("#shackWidth").show();
        $("#shackLengthInput").attr("required", true);
        $("#shackWidthInput").attr("required", true);
    } else {
        $("#shackLengthInput").attr("required", false);
        $("#shackWidthInput").attr("required", false);
        $("#shackLengthInput").val(null);
        $("#shackWidthInput").val(null);
        $("#shackLength").hide();
        $("#shackWidth").hide();
        $("#shackCheckbox").attr("value", null);
    }
});

$('select[name=length]').on('change', function () {
    $("#shackLengthInput").attr({
        "max": (this.value / 2),
        "min": 100
    });
});
$('select[name=width]').on('change', function () {
    $("#shackWidthInput").attr({
        "max": this.value,
        "min": 100
    });
});