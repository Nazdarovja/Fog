function confirmFunction() {
    alert("Forespørgsel er nu sendt til Fog. Tak for din henvendelse");
}

// Adds options to jsp after Calculate button
function check() {
    if ($("#shackCheckboxCheck").val() !== "") {
        $("#shackCheckbox").attr("checked", true);
        $("#shackLength").show();
        $("#shackWidth").show();

        $("#shackLengthInput").attr("required", true);
        $("#shackWidthInput").attr("required", true);
        restrictLength();
        restrictWidth();
    }
    if (document.getElementById("roofTypeCheck").value === "rejsning") {
        $("#angle").show();
    } else {
        $("#angle").hide();
    }
    if (document.getElementById("shackCheckboxCheck").value === "") {
        $("#shackLength").hide();
        $("#shackWidth").hide();
        $("#shackLengthInput").attr("value", null);
        $("#shackWidthInput").attr("value", null);
    }
}
check();

// Adds angle option, when rejsning is chosen in the dropdown.
$('select[name=roofType]').on('change', function () {
    if (this.value === "rejsning") {
        $("#angle").show();
    } else {
        $("#angle").hide();
    }
});

// Adds Length and Height visibilty to jsp
$('input[name=shackCheckbox]').on('change', function () {
    if ($(this).is(':checked')) {
        $("#shackLength").show();
        $("#shackWidth").show();
        $("#shackLengthInput").attr("required", true);
        $("#shackWidthInput").attr("required", true);
        restrictLength();
        restrictWidth();
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
        "max": $("#length").val() / 2,
        "min": 100,
        "placeholder": "Tillad længde fra 100 til " + ($("#length").val() / 2)
    });
});

$('select[name=width]').on('change', function () {
    $("#shackWidthInput").attr({
        "max": $("#width").val(),
        "min": widthRules(),
        "placeholder": "Tillad bredde fra " + widthRules() + " til " + $("#width").val()
    });
});

function restrictWidth() {
    $("#shackWidthInput").attr({
        "max": $("#width").val(),
        "min": widthRules(),
        "placeholder": "Tillad bredde fra " + widthRules() + " til " + $("#width").val()
    });
}
;
function restrictLength() {
    $("#shackLengthInput").attr({
        "max": $("#length").val() / 2,
        "min": 100,
        "placeholder": "Tillad længde fra 100 til " + ($("#length").val() / 2)
    });
}
;
function widthRules() {
    if ($("#width").val() <= 400) {
        return $("#width").val();
    } else
        return 100;
}
;