Number.prototype.formatMoney = function(c, d, t) {
	var n = this, 
	    c = isNaN(c = Math.abs(c)) ? 2 : c, 
	    d = d == undefined ? "." : d, 
	    t = t == undefined ? "," : t, 
	    s = n < 0 ? "-" : "", 
	    i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", 
	    j = (j = i.length) > 3 ? j % 3 : 0;
	return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
};


function revisaNumero(isFloat, value, e, nameFunction, args) {
	//console.log(nameFunction);
	var arr;
	if (isFloat) // Allow: backspace, delete, tab, escape, enter, '.'
		arr = [46, 8, 9, 27, 13, 110, 190];
	else
		arr = [46, 8, 9, 27, 13, 110];
    if ($.inArray(e.keyCode, arr) != -1
    		// Allow: Ctrl+A, Command+A
    		|| (e.keyCode == 65 && ( e.ctrlKey === true || e.metaKey === true ) )
    		// Allow: Ctrl+C, Command+C
    		|| (e.keyCode == 67 && ( e.ctrlKey === true || e.metaKey === true ) )
    		// Allow: Ctrl+V, Command+V
    		|| (e.keyCode == 86 && ( e.ctrlKey === true || e.metaKey === true ) )
    		// Allow: home, end, left, right, down, up
    		|| (e.keyCode >= 35 && e.keyCode <= 40)) {
             // let it happen, don't do anything
    	if ( e.keyCode == 13 && nameFunction != null )
    		return window[nameFunction].apply(args);
    	else
            return;
    }
    // Ensure that it is a number and stop the keypress
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
        e.preventDefault();
    }
}

function aceptaIntro(e, nameFunction, args) {
	if (e.keyCode == 13 && nameFunction != null )
		return window[nameFunction].apply(args);
}