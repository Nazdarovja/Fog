function confirmFunction() {
    alert("Forespørgsel er nu sendt til Fog. Tak for din henvendelse");
}

function findInquiries(cosEmail) {
    var email = cosEmail;
    window.open("/Fog/FrontController?command=inquiry&customer=" + email, "nameofwindow", "directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=1600,height=600");
}

function sortTable(idTable, sortIndex) {
    var table, rows, switching, i, x, y, shouldSwitch;

    table = document.getElementById(idTable);

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
            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                // I so, mark as a switch and break the loop:
                shouldSwitch = true;
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

