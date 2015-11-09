var str;
function check(decId, binId, hexId) {
    var d = document.getElementById(decId).checked;
    var b = document.getElementById(binId).checked;
    var h = document.getElementById(hexId).checked;
    if (d) {
        str = "dec";
        return str;
    } else if (b) {
        str = "bin";
        return str;
    } else {
        str = "hex";
        return str;
    }
}
var ex;
var res;
var pattern1 = /-?\d+/g;
var pattern2 = /[0-9a-fA-F]+/g;


function changeD(resultId) {
    if (str == "bin") {
        ex = document.getElementById(resultId).value;
        res = ex.replace(pattern1, function myFunction(x){return parseInt(x, 2);});
        document.getElementById(resultId).value = res;
    } else  if (str == "hex") {
        ex = document.getElementById(resultId).value;
        res = ex.replace(pattern2, function myFunction(x){return parseInt(x, 16);});
        document.getElementById(resultId).value = res;
    }
};
function changeB(resultId) {
    if (str == "dec") {
        ex = document.getElementById(resultId).value;
        res = ex.replace(pattern1, function myFunction(x){return parseInt(x, 10).toString(2);});
        document.getElementById(resultId).value = res;
    } else  if (str == "hex") {
        ex = document.getElementById(resultId).value;
        res = ex.replace(pattern2, function myFunction(x){return parseInt(x, 16).toString(2);});
        document.getElementById(resultId).value = res;
    }
};
function changeH(resultId) {
    if (str == "bin") {
        ex = document.getElementById(resultId).value;
        res = ex.replace(pattern1, function myFunction(x){return parseInt(x, 2).toString(16);});
        document.getElementById(resultId).value = res;
    } else  if (str == "dec") {
        ex = document.getElementById(resultId).value;
        res = ex.replace(pattern1, function myFunction(x){return parseInt(x, 10).toString(16);});
        document.getElementById(resultId).value = res;
    }
}