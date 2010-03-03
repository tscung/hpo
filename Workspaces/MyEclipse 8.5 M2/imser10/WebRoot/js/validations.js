//VALIDATIONS
function validateDates(form) {
	if (form.dateCreatedLower.value != '' && form.dateCreatedUpper.value != '')
		return validateDates(form.dateCreatedLower.value,form.dateCreatedUpper.value);
	else
		//leave to validator validation
		return true;
}
function validateIdentical(value1,value2) {
	if (value1 != '' || value2 != '')
		return value1 == value2;
	else
		//leave to validator validation
		return true;
}
function validateDates(startDateString, endDateString){
	var success=true;

	//get position of delims.
	var sDdelim_01_pos=startDateString.indexOf('/'),sDdelim_02_pos=startDateString.lastIndexOf('/');
	var eDdelim_01_pos=endDateString.indexOf('/'),eDdelim_02_pos=endDateString.lastIndexOf('/');

	//parse strings into dmy
	var startDateDay='',startDateMonth='',startDateYear='';
	for (i=0; i<sDdelim_01_pos; i++) startDateYear=startDateYear+startDateString.charAt(i);
	for (i=sDdelim_01_pos+1; i<sDdelim_02_pos; i++) startDateMonth=startDateMonth+startDateString.charAt(i);
	for (i=sDdelim_02_pos+1; i<startDateString.length; i++) startDateDay=startDateDay+startDateString.charAt(i);
	var endDateDay='',endDateMonth='',endDateYear='';
	for (i=0; i<eDdelim_01_pos; i++) endDateYear=endDateYear+endDateString.charAt(i);
	for (i=eDdelim_01_pos+1; i<eDdelim_02_pos; i++) endDateMonth=endDateMonth+endDateString.charAt(i);
	for (i=eDdelim_02_pos+1; i<endDateString.length; i++) endDateDay=endDateDay+endDateString.charAt(i);

	//put tokens into date objects
	var startDate=new Date(),endDate=new Date();
	startDate.setDate(startDateDay);
	startDate.setMonth(startDateMonth-1);
	startDate.setYear(startDateYear);
	endDate.setDate(endDateDay);
	endDate.setMonth(endDateMonth-1);
	endDate.setYear(endDateYear);

	//compare date objects
	if (startDate>endDate) {
		success=false;
	}

	return success;
}


// ===================================================================
// Author: Matt Kruse <matt@mattkruse.com>
// WWW: http://www.mattkruse.com/
//
// NOTICE: You may use this code for any purpose, commercial or
// private, without any further permission from the author. You may
// remove this notice from your final code if you wish, however it is
// appreciated by the author if at least my web site address is kept.
//
// You may *NOT* re-distribute this code in any way except through its
// use. That means, you can include it in your product, or your web
// site, or any other form where the code is actually being used. You
// may not put the plain javascript up on your site for download or
// include it in your javascript libraries for download.
// If you wish to share this code with others, please just point them
// to the URL instead.
// Please DO NOT link directly to my .js files from your site. Copy
// the files to your server and use them there. Thank you.
// ===================================================================

// HISTORY
// ------------------------------------------------------------------
// December 29, 2003: Added the option to specify a delimiter for
//    multiple valued input field via getInputValue(), etc.

//-------------------------------------------------------------------
// Trim functions
//   Returns string with whitespace trimmed
//-------------------------------------------------------------------
function LTrim(str){
	if (str==null){return null;}
	for(var i=0;str.charAt(i)==" ";i++);
	return str.substring(i,str.length);
	}
function RTrim(str){
	if (str==null){return null;}
	for(var i=str.length-1;str.charAt(i)==" ";i--);
	return str.substring(0,i+1);
	}
function Trim(str){return LTrim(RTrim(str));}
function LTrimAll(str) {
	if (str==null){return str;}
	for (var i=0; str.charAt(i)==" " || str.charAt(i)=="\n" || str.charAt(i)=="\t"; i++);
	return str.substring(i,str.length);
	}
function RTrimAll(str) {
	if (str==null){return str;}
	for (var i=str.length-1; str.charAt(i)==" " || str.charAt(i)=="\n" || str.charAt(i)=="\t"; i--);
	return str.substring(0,i+1);
	}
function TrimAll(str) {
	return LTrimAll(RTrimAll(str));
	}
//-------------------------------------------------------------------
// isNull(value)
//   Returns true if value is null
//-------------------------------------------------------------------
function isNull(val){return(val==null);}

//-------------------------------------------------------------------
// isBlank(value)
//   Returns true if value only contains spaces
//-------------------------------------------------------------------
function isBlank(val){
	if(val==null){return true;}
	for(var i=0;i<val.length;i++) {
		if ((val.charAt(i)!=' ')&&(val.charAt(i)!="\t")&&(val.charAt(i)!="\n")&&(val.charAt(i)!="\r")){return false;}
		}
	return true;
	}

//-------------------------------------------------------------------
// isInteger(value)
//   Returns true if value contains all digits
//-------------------------------------------------------------------
function isInteger(val){
	if (isBlank(val)){return false;}
	for(var i=0;i<val.length;i++){
		if (val.charAt(i)!='.') {
		if(!isDigit(val.charAt(i))){return false;}
		}
	}
	return true;
}

//-------------------------------------------------------------------
// isNumeric(value)
//   Returns true if value contains a positive float value
//-------------------------------------------------------------------
function isNumeric(val){return(parseFloat(val,10)==(val*1));}

//-------------------------------------------------------------------
// isArray(obj)
// Returns true if the object is an array, else false
//-------------------------------------------------------------------
function isArray(obj){return(typeof(obj.length)=="undefined")?false:true;}

//-------------------------------------------------------------------
// isDigit(value)
//   Returns true if value is a 1-character digit
//-------------------------------------------------------------------
function isDigit(num) {
	if (num.length>1){return false;}
	var string="1234567890";
	if (string.indexOf(num)!=-1){return true;}
	return false;
	}