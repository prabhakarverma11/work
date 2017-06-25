var ErrMsg = "";
var retval=false;
var ok;


function ValidateForm(theForm)
{

    ErrMsg = "";
    //ErrMsg = "The following errors are occured\n\n";
	ok = true;
	
	var Validations = new Array()			
	var FieldsToValidate = new Array();
		//alert('yo1:   '+theForm.Validation.value); 
		if (!theForm.Validation.value) return true;
		if (trim(theForm.Validation.value) == '') return true;
	FieldsToValidate = theForm.Validation.value.split("^");
	
	for(i=0;i<FieldsToValidate.length;i++)
	{

		var FieldAttribs = new Array();
		FieldAttribs=FieldsToValidate[i].split("|");
		
		Validations[i] = new Array(FieldAttribs.length);
		for(j=0;j<FieldAttribs.length;j++)
		{
			
			var values = new Array();
			values = FieldAttribs[j].split("=");
			
			Attrib = trim(values[0]);
			AttribValue = trim(values[1]);
			Validations[i][Attrib]=AttribValue;
			
		}
	}
	
	for(i=0; i<Validations.length;i++)
	{
	
	    switch (Validations[i]["Validate"].toUpperCase())
		{
		
			case "COMPARE":	
		     	ValidateCompare(theForm[Validations[i]["Field"]], Validations[i]);		     			     
			break;
			case "BLANK":	
		        ValidateBlank(theForm[Validations[i]["Field"]], Validations[i]);
		   	break;
			case "CONFIRMPASSWORD":
				ValidateConfirmPassword(theForm, theForm[Validations[i]["Field"]], Validations[i]);					
			break;
			case "EMAIL":
				ValidateEmail(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "SELECT":
				ValidateRadio(theForm, Validations[i]["Field"], Validations[i]);				
			break;
			case "MULTISELECT":
				ValidateCheckBox(theForm, Validations[i]["Field"], Validations[i]);				
			break;
			case "TOPMINUSMULTISELECT":
				ValidateListBox(theForm, Validations[i]["Field"], Validations[i]);				
			break;
			case "COMBO":
				ValidateComboBox(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "NUMERIC":
				ValidateNumeric(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "DECIMAL":
				ValidateDecimal(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "ALPHA":
				ValidateAlpha(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "ALPHANUMERIC":
				ValidateAlphaNumeric(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "FILEEXTENSION":
				ValidateFileExtension(theForm[Validations[i]["Field"]], Validations[i]);
			break;
			case "STRINGMATCH":
				ValidateString(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "REGULAREXPRESSION":
				ValidateRegExp(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "DATE":
				ValidateDate(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "COMPAREDATE":
				ValidateCompareDate(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "USSTATE":
				ValidateUSState(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "USZIP":
				ValidateUSZIP(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "ZIP":
				ValidateZIP(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "PHONE":		
				ValidatePhone(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "USPHONE":		
				ValidateUSPhone(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
				case "URL":		
				ValidateURL(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			
			case "PERCENTAGERANGE":		
				ValidatePercentageRange(theForm[Validations[i]["Field"]], Validations[i]);				
			break;
			case "CHECKLENGTH":
				checkLength(theForm[Validations[i]["Field"]], Validations[i]);
				
			break;
		}
		
	}
	
//	if(!ok)
//		alert(ErrMsg);

	return ok;
}


function rightTrim(strValue) {
var objRegExp = /^([\w\W]*)(\b\s*)$/;
      if(objRegExp.test(strValue)) {
       strValue = strValue.replace(objRegExp, '$1');
    }
  return strValue;
}

function leftTrim(strValue) {
var objRegExp = /^(\s*)(\b[\w\W]*)$/;
 
      if(objRegExp.test(strValue)) {
       strValue = strValue.replace(objRegExp, '$2');
    }
  return strValue;
}

function trim(strValue) {
 var objRegExp = /^(\s*)$/;
    if(objRegExp.test(strValue)) {
       strValue = strValue.replace(objRegExp, '');
       if( strValue.length == 0)
          return strValue;
    }
   objRegExp = /^(\s*)([\W\w]*)(\b\s*$)/;
   if(objRegExp.test(strValue)) {
       strValue = strValue.replace(objRegExp, '$2');
    }
  return strValue;
}
function checkBlank(Element, FieldAttrib)
{
	if(trim(Element.value)=="")
	{
		ErrMsg+="- Please enter "+FieldAttrib["Alias"]+"\n";
		ok=false;		
		SetFocus(Element);        
		return false;
		
	}
	else
	{
	
        Element.style.backgroundColor='White' ;
		return true;
    }
}
function checkLength(Element, FieldAttrib)
{
	if(FieldAttrib["Length"])
	{
		if(Element.value.length>FieldAttrib["Length"])
		{
			ErrMsg+="- "+FieldAttrib["Alias"]+" should be less than or equals to "+FieldAttrib["Length"]+" character\n";
			ok=false;
			SetFocus(Element);            
			return false;
		}
		else
		{
		    Element.style.backgroundColor='White' ;
			return true;
		}
	}
}

function CompareTo(Element, FieldAttrib)
{
	if(FieldAttrib["CompareTo"])
	{
		if(Element.value!=FieldAttrib["CompareTo"])
		{
			ErrMsg+="- "+FieldAttrib["Alias"]+" should be same as "+FieldAttrib["Alias1"]+"\n";
			ok=false;
			SetFocus(Element);            
			return false;
		}
		else
		{
			return true;
			Element.style.backgroundColor='White' ;
		}
		
	}
}

function checkPhone(Element, FieldAttrib)
{
	StringToMatch = FieldAttrib["Characters"];
	var totaldigits = 0;
	for(var i=0;i<Element.value.length;i++)
	{
		if(StringToMatch.indexOf(Element.value.charAt(i))<0)
		{
			ErrMsg+="- Please enter a valid value for "+FieldAttrib["Alias"]+"\n";
			ok=false;
			SetFocus(Element);            
			return false;
			break;
		}
		if(!isNaN(Element.value.charAt(i)))
			totaldigits++
	}
	if(totaldigits<FieldAttrib["MinDigits"])
	{
		ErrMsg+="- "+FieldAttrib["Alias"]+" should contain at least "+ FieldAttrib["MinDigits"] +" digits\n";
		ok=false;
			SetFocus(Element);            
		return false;
	}
	else
	{
	    Element.style.backgroundColor='White' ;
		return true;
	}
}

function checkRegExp(Element, RegExpString, FieldAttrib)
{
	
	if(!RegExpString.test(Element.value))
	{
		ErrMsg+="- Please enter a proper value of "+FieldAttrib["Alias"]+"\n";
		ok=false;
		SetFocus(Element);        
		return false;
	}
	else
	{
	    Element.style.backgroundColor='White' ;
		return true;
	}
}

function compareDate(Element,strValue, Format, FieldAttrib,MinDate)
{
  	if(MinDate != "")
	{
	    strValue =  Date.parse(strValue);
	    MinDate =  Date.parse(MinDate);
	    
	    if(strValue < MinDate)
	    {
	        ErrMsg+="- "+FieldAttrib["Alias"]+" should not less then Today's Date\n";
	        ok=false;	
	        SetFocus(Element);     	
	        return ok;
	    }
	    else
	    {
	        
	    }
	}	
}

function checkDate(Element,strValue, Format, FieldAttrib)
{
	
	if(FieldAttrib["FullYear"]){
		if(FieldAttrib["FullYear"]=="Yes"){
			var objRegExp = /^\d{1,2}(\/)\d{1,2}(\/)\d{1,4}$/;
		}else{
			var objRegExp = /^\d{1,2}(\/)\d{1,2}(\/)\d{1,2}$/;
		}
	}
	else
	{
			
		var objRegExp = /^\d{1,2}(\/)\d{1,2}(\/)\d{1,2}$/;
	}
  	if(!objRegExp.test(strValue))
	{
		ErrMsg+="- Please enter a valid date for "+FieldAttrib["Alias"]+"\n";
		ok=false;	
		SetFocus(Element);     	
		return ok;
	}
  	else
	{
		var arrayDate = strValue.split("\/"); //split date into month, day, year
	    
		if(Format=="mm/dd/yy" || Format=="mm/dd/yyyy")
		{
			var intDay = parseInt(arrayDate[1],10); 
			var intYear = parseInt(arrayDate[2],10);
			var intMonth = parseInt(arrayDate[0],10);
		}
		else if(Format=="dd/mm/yy" || Format=="dd/mm/yyyy")
		{	
			var intDay = parseInt(arrayDate[0],10); 
			var intYear = parseInt(arrayDate[2],10);
			var intMonth = parseInt(arrayDate[1],10);
		}
		if(intMonth > 12 || intMonth < 1) {
			ErrMsg+="- Please enter a valid date for "+FieldAttrib["Alias"]+"\n";
			ok=false;
			SetFocus(Element);     
			return ok;
		}
		else
		{
			var arrayLookup = { '1' : 31,'3' : 31, '4' : 30,'5' : 31,'6' : 30,'7' : 31,
								'8' : 31,'9' : 30,'10' : 31,'11' : 30,'12' : 31}
			if(intMonth != 2) {
			  if(intDay <= arrayLookup[intMonth] && intDay != 0)
				return true;
			}
			else
			{
				if(FieldAttrib["FullYear"]=="Yes"){
					var booLeapYear = (intYear % 4 == 0 && (intYear % 100 != 0 || intYear % 400 == 0));
					if( ((booLeapYear && intDay <= 29) || (!booLeapYear && intDay <=28)) && intDay !=0)
					  return true;
				}else{
					return true;
				}
			}
		}
	}
	ErrMsg+="- Please enter a valid date for "+FieldAttrib["Alias"]+"\n";
	ok=false;
	SetFocus(Element);     
  	return false;
}

function checkStringMatch(Element, FieldAttrib)
{
	StringToMatch = FieldAttrib["StringToMatch"];
	for(var i=0;i<Element.value.length;i++)
	{
		if(StringToMatch.indexOf(Element.value.charAt(i))<0)
		{
			ErrMsg+="- Please enter a valid value for "+FieldAttrib["Alias"]+"\n";
			ok=false;
			SetFocus(Element);            
			return false;
			break;
		}
	}
	return true;
}


function ValidateCompare(Element, FieldAttrib)
{
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			CompareTo(Element, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			CompareTo(Element, FieldAttrib);
	}
}


function ValidatePhone(Element, FieldAttrib)
{
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkPhone(Element, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkPhone(Element, FieldAttrib);
	}
}
function ValidateUSPhone(Element, FieldAttrib)
{
	var objRegExp  = /^\(?[2-9]\d{2}[\)\.-]?\s?\d{3}[\s\.-]?\d{4}$/;
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	
}

function ValidateURL(Element, FieldAttrib)
{
 	//var objRegExp  = http(s)?://+([\w-]+\.)+[\w-]+(/[\w- ./?%&=]*)?;
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	
}

function ValidateBlank(Element, FieldAttrib)
{

	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkLength(Element, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
		    CompareTo(Element, FieldAttrib);
	}
	
   
}

function ValidateZIP(Element, FieldAttrib)
{
	var objRegExp  =  /^[a-zA-Z0-9]+$/;
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
}
function ValidateUSState(Element, FieldAttrib)
{
	var objRegExp = /^(AK|AL|AR|AZ|CA|CO|CT|DC|DE|FL|GA|HI|IA|ID|IL|IN|KS|KY|LA|MA|MD|ME|MI|MN|MO|MS|MT|NB|NC|ND|NH|NJ|NM|NV|NY|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VA|VT|WA|WI|WV|WY)$/i; 
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
}


function ValidateUSZIP(Element, FieldAttrib)
{
	var objRegExp  = /(^\d{5}$)|(^\d{5}-\d{4}$)/;
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
}

function ValidateEmail(Element, FieldAttrib)
{
	var objRegExp  = /^[a-z0-9]([a-z0-9_\-\.]*)@([a-z0-9_\-\.]*)(\.[a-z]{2,3}(\.[a-z]{2}){0,2})$/i;
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
}
function ValidateNumeric(Element, FieldAttrib)
{
	var objRegExp  = /(^-?\d\d*$)/;
	if(FieldAttrib["Optional"])
	{	
		if(trim(Element.value)!="")
			if(checkRegExp(Element, objRegExp, FieldAttrib)){
				if(FieldAttrib["Minimum"] && !isNaN(FieldAttrib["Minimum"])){
					if(Element.value<FieldAttrib["Minimum"]){
						ErrMsg+="- Value of "+FieldAttrib["Alias"]+" should be at least "+FieldAttrib["Minimum"]+"\n";
						ok=false;
						SetFocus(Element);                        
						return false;
					}
				}
				if(FieldAttrib["Maximum"] && !isNaN(FieldAttrib["Maximum"])){
					if(Element.value>FieldAttrib["Maximum"]){
						ErrMsg+="- Value of "+FieldAttrib["Alias"]+" should be less than "+FieldAttrib["Maximum"]+"\n";
						ok=false;
						SetFocus(Element);                        
						return false;
					}
				}
			}
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			if(checkRegExp(Element, objRegExp, FieldAttrib)){
				if(FieldAttrib["Minimum"] && !isNaN(FieldAttrib["Minimum"])){
					if(Element.value<FieldAttrib["Minimum"]){
						ErrMsg+="- Value of "+FieldAttrib["Alias"]+" should be at least "+FieldAttrib["Minimum"]+"\n";
						ok=false;
						SetFocus(Element);                        
						return false;
					}
				}
				if(FieldAttrib["Maximum"] && !isNaN(FieldAttrib["Maximum"])){
					if(Element.value>FieldAttrib["Maximum"]){
						ErrMsg+="- Value of "+FieldAttrib["Alias"]+" should be less than "+FieldAttrib["Maximum"]+"\n";
						ok=false;
						SetFocus(Element);                        
						return false;
					}
				}
			}
	}
}

function ValidateDecimal(Element, FieldAttrib)
{
	//alert(element);
	
	var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/; 
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			if(checkRegExp(Element, objRegExp, FieldAttrib)){
				if(FieldAttrib["Minimum"] && !isNaN(FieldAttrib["Minimum"])){
					if(Element.value<FieldAttrib["Minimum"]){
						ErrMsg+="- Value of "+FieldAttrib["Alias"]+" should be at least "+FieldAttrib["Minimum"]+"\n";
						ok=false;
						SetFocus(Element);                        						
						return false;
					}
				}
				if(FieldAttrib["Maximum"] && !isNaN(FieldAttrib["Maximum"])){
					if(Element.value>FieldAttrib["Maximum"]){
						ErrMsg+="- Value of "+FieldAttrib["Alias"]+" should be less than "+FieldAttrib["Maximum"]+"\n";
						ok=false;
						SetFocus(Element);                        
						return false;
					}
				}
			}
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			if(checkRegExp(Element, objRegExp, FieldAttrib)){
				if(FieldAttrib["Minimum"] && !isNaN(FieldAttrib["Minimum"])){
					if(Element.value<FieldAttrib["Minimum"]){
						ErrMsg+="- Value of "+FieldAttrib["Alias"]+" should be at least "+FieldAttrib["Minimum"]+"\n";
						ok=false;
						SetFocus(Element);                        
						return false;
					}
				}
				if(FieldAttrib["Maximum"] && !isNaN(FieldAttrib["Maximum"])){
					if(Element.value>FieldAttrib["Maximum"]){
						ErrMsg+="- Value of "+FieldAttrib["Alias"]+" should be less than "+FieldAttrib["Maximum"]+"\n";
						ok=false;
						SetFocus(Element);                        
						return false;
					}
				}
			}
	}
}

function ValidateAlphaNumeric(Element, FieldAttrib)
{
	var objRegExp  =  /^[a-zA-Z0-9]+$/;
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
}

function ValidateAlpha(Element, FieldAttrib)
{
	var objRegExp  =  /^[a-zA-Z]+$/;
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkRegExp(Element, objRegExp, FieldAttrib);
	}
}

function ValidateDate(Element, FieldAttrib)
{
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			
			checkDate(Element,Element.value, FieldAttrib["Format"], FieldAttrib,FieldAttrib["MINDATE"]);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))			
			checkDate(Element,Element.value, FieldAttrib["Format"], FieldAttrib,FieldAttrib["MINDATE"]);
	}
}
function ValidateCompareDate(Element, FieldAttrib)
{
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			
			compareDate(Element,Element.value, FieldAttrib["Format"], FieldAttrib,FieldAttrib["MINDATE"]);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))			
			compareDate(Element,Element.value, FieldAttrib["Format"], FieldAttrib,FieldAttrib["MINDATE"]);
	}
}
function ValidateRegExp(Element, FieldAttrib)
{
	
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkRegExp(Element.value, FieldAttrib["Format"], FieldAttrib);
	}
	else
	{
		
		if(checkBlank(Element, FieldAttrib))
			checkRegExp(Element.value, FieldAttrib["Format"], FieldAttrib);
	}
}

function ValidateString(Element, FieldAttrib)
{
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
			checkStringMatch(Element, FieldAttrib);
	}
	else
	{
		if(checkBlank(Element, FieldAttrib))
			checkStringMatch(Element, FieldAttrib);
	}	
}

function ValidateRadio(theForm, Element, FieldAttrib)
{
	for(var i=0;i<theForm[Element].length;i++)
	{
		if(theForm[Element][i].checked==true)
		{
			return true;
			break;
		}
	}
	ErrMsg+="- Please select a value for "+FieldAttrib["Alias"]+"\n";
	ok=false;
	SetFocus(Element);    
	return false;
}

function ValidateCheckBox(theForm, Element, FieldAttrib)
{
	ElementName=Element;
	var NoOfChecked=0;
	if(FieldAttrib["Optional"])
	{
		if(FieldAttrib["Max"])
		{
			for(var i=0;i<theForm[ElementName].length;i++)
			{
				if(theForm[ElementName][i].checked==true)
					NoOfChecked++;
			}
			if(NoOfChecked!=0)
			{
				if(NoOfChecked>FieldAttrib["Max"])
				{
					ErrMsg+="- You can select maximum "+FieldAttrib["Max"]+" value(s) for "+FieldAttrib["Alias"]+"\n";
					ok=false;
					SetFocus(Element);                    
					return false;
				}
			}
		}
	}
	else
	{
		if(theForm[ElementName].length){
			for(var i=0;i<theForm[ElementName].length;i++)
			{
				if(theForm[ElementName][i].checked==true)
					NoOfChecked++;
			}
		}
		else{
				if(theForm[ElementName].checked==true)
					NoOfChecked++;
		}
		if(NoOfChecked==0)
		{
			ErrMsg+="- Please select a value for "+FieldAttrib["Alias"]+"\n";
			ok=false;
			SetFocus(Element);            
			return false;
		}
		else if(FieldAttrib["Max"])
		{
			if(NoOfChecked>FieldAttrib["Max"])
			{
				ErrMsg+="- You can select maximum "+FieldAttrib["Max"]+" value(s) for "+FieldAttrib["Alias"]+"\n";
				ok=false;
				SetFocus(Element);                
				return false;
			}
		}
	}
}
function ValidateCheckBox(theForm, Element, FieldAttrib)
{
	ElementName=Element;
	var NoOfChecked=0;
	if(FieldAttrib["Optional"])
	{
		if(FieldAttrib["Max"])
		{
			for(var i=0;i<theForm[ElementName].length;i++)
			{
				if(theForm[ElementName][i].checked==true)
					NoOfChecked++;
			}
			if(NoOfChecked!=0)
			{
				if(NoOfChecked>FieldAttrib["Max"])
				{
					ErrMsg+="- You can select maximum "+FieldAttrib["Max"]+" value(s) for "+FieldAttrib["Alias"]+"\n";
					ok=false;
					SetFocus(Element);                    
					return false;
				}
			}
		}
	}
	else
	{
		if(theForm[ElementName].length){
			for(var i=0;i<theForm[ElementName].length;i++)
			{
				if(theForm[ElementName][i].checked==true)
					NoOfChecked++;
			}
		}
		else{
				if(theForm[ElementName].checked==true)
					NoOfChecked++;
		}
		if(NoOfChecked==0)
		{
			ErrMsg+="- Please select a value for "+FieldAttrib["Alias"]+"\n";
			ok=false;
			SetFocus(Element);            
			return false;
		}
		else if(FieldAttrib["Max"])
		{
			if(NoOfChecked>FieldAttrib["Max"])
			{
				ErrMsg+="- You can select maximum "+FieldAttrib["Max"]+" value(s) for "+FieldAttrib["Alias"]+"\n";
				ok=false;
				SetFocus(Element);                
				return false;
			}
		}
	}
}

function ValidateComboBox(Element, FieldAttrib)
{    
	if(Element.value < 0 || Element.value==0)
	{
		ErrMsg+="- Please select a value for "+FieldAttrib["Alias"]+"\n";
		ok=false;
		SetFocus(Element);        
		return false;
	}
	else
	{
		Element.style.backgroundColor='white' ;
	}
}

function ValidateConfirmPassword(theForm, Element, FieldAttrib)
{
	if(checkBlank(Element, FieldAttrib))
	{
		if(Element.value!=theForm[FieldAttrib["CompareTo"]].value)
		{
			ErrMsg+="- Password and Confirm Password should be same\n";
			ok=false;
			SetFocus(Element);            
			return false;
		}
		else
		{
		    Element.style.backgroundColor='White' ;
		}
	}
}

function checkUploadFile(Element, FieldAttrib)
{
	if(trim(Element.value)=="")
	{
		ErrMsg+="- Please Upload "+FieldAttrib["Alias"]+"\n";
		ok=false;		
		SetFocus(Element);        
		return false;		
	}
	else
	{
	
        Element.style.backgroundColor='White' ;
		return true;
    }
}

function ValidateFileExtension(Element, FieldAttrib)
{
	
	if(FieldAttrib["Optional"])
	{
		if(trim(Element.value)!="")
		{
			if(Element.Extensions)
			{
					
				ArrExt = new Array();
				ArrExt = FieldAttrib["Extensions"].split(",");
				Ext = Element.value.toUpperCase;
				alert(Ext);
				for(var i=0;i<ArrExt.length;i++)
				{
					if(ArrExt[i].toUpperCase ==Ext.toUpperCase)
					return true;
					break;
				}
				
				ErrMsg+="- Only";
				for(var i=0;i<ArrExt.length;i++)
				{
					ErrMsg+=" "+ArrExt[i].toUpperCase();
				}
				ErrMsg+=" files are allowed for "+FieldAttrib["Alias"]+"\n";
				ok=false;
				SetFocus(Element);                
				return false;
			}
		}
		
	}
	else
	{
	    if(FieldAttrib["Extensions"])
	    {
	        if (checkUploadFile(Element, FieldAttrib))
	        {
		        ArrExt = new Array();
		        ArrExt = FieldAttrib["Extensions"].split(",");

		        Ext = Element.value.substr(Element.value.lastIndexOf(".")+0);    		
			   
	             if (trim(Element.value) == "")
	            {
	                ErrMsg+="- Please Upload "+FieldAttrib["Alias"]+"\n";
	                return false;
	             }

		        for(var i=0;i<ArrExt.length;i++)
		        {
    				
			        if(ArrExt[i].toUpperCase()==Ext.toUpperCase())
			        {
			        return true;
			        break;
			        }
		        }
    			
		        ErrMsg+="- Only";
		        for(var i=0;i<ArrExt.length;i++)
		        {
			        ErrMsg+=" "+ArrExt[i].toUpperCase();
		        }
		        ErrMsg+=" files are allowed for "+FieldAttrib["Alias"]+"\n";
		        ok=false;
		        SetFocus(Element);            
		        return false;
		    }  
	    }		
	}
}
function isDateValid(fieldValue) 
{

	var doc = "document."
   // str=eval(doc+formName+"."+fieldName+".value");
	
	var dateStr=fieldValue;
	
	var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{4})$/; // requires 4 digit year

	var matchArray = dateStr.match(datePat); // is the format ok?
	
	if (matchArray == null) 
	{
		//alert(msg);
		//eval(doc+formName+"."+fieldName + ".focus()");
		return false;
	}
	month = matchArray[1]; // parse date into variables
	day = matchArray[3];
	year = matchArray[4];
	
	if (month < 1 || month > 12) 
	{
		alert("Month must be between 1 and 12.");
		return false;
	}
	
	if (day < 1 || day > 31) 
	{
		alert("Day must be between 1 and 31.");
		return false;
	}
	if ((month==4 || month==6 || month==9 || month==11) && day==31) 
	{
		alert("Month "+month+" doesn't have 31 days!")
		return false;
	}
	if (month == 2)
	{ // check for february 29th
		var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		if (day>29 || (day==29 && !isleap)) 
		{
			alert("February " + year + " doesn't have " + day + " days!");
			return false;
   		}
	}
	return true;
}
function isDecimal(fieldValue)
	{
		//formName='Form1';
		//msg='Invalid price';

		//var     doc = "document."
		//a=eval(doc+formName+"."+fieldName);
		//fieldValue=eval(doc+formName+"."+fieldName + ".value");
		
			if (fieldValue.length<1)
			{ return false;}
			//alert(fieldValue.length);
			if (fieldValue.length==1){chr=fieldValue.charAt(0);if(chr == '.'){ return false;}}

			chk1="123456789.0";
			var dot=0;
                for(i=0;i!=fieldValue.length;i++)
				{
						ch1=fieldValue.charAt(i);
						if (ch1 == '.')
						 {
							dot = dot + 1;
						 }
						rtn1=chk1.indexOf(ch1);
						if((rtn1==-1) || (dot>1))
						{
							 	//eval(doc+formName+"."+fieldName + ".focus()")
								return false;
								break;
						}
		        }
		    return true
	}
	
function changetoobject(Fieldname,FieldType)
{
	var	ret;
	var	i;
	//alert('Fieldname: '+ Fieldname);
	//alert('FieldType: '+ FieldType);
	//alert('frmname: '+ document.forms[0].name);
	var length = document.forms[0].elements.length;
	//alert('length: '+ length);
	
	for(i=1; i<=length-1;i++)
	{	
	          var obj=document.forms[0].elements[i];
			
				if(FieldType == 0)
				{
					var isobj = obj.name.indexOf(Fieldname)
					if(isobj >= 0) 
					{
						ret=obj;
						break;
					}
				}
				else
				{
					//alert('Id type');
					
					var isobj = obj.id.indexOf(Fieldname);
					//alert('id working');
					if(isobj >= 0) 
					{
					   // alert('id working................ yahooooooooooooooo');
						ret=obj;
						break;
					}
				}
		
	}
	
	return ret;
}



function getobjectstring(Fieldname,FieldType)
{
	//FieldType=1 = Object ID
	//FieldType=0 = Object Name
	var	ret;
	var	i;
	//alert('Fieldname: '+ Fieldname);
	//alert('FieldType: '+ FieldType);
	//alert('frmname: '+ document.forms[0].name);
	var length = document.forms[0].elements.length;
	
	
	for(i=1; i<=length;i++)
	{	
	          var obj=document.forms[0].elements[i];
	          
			  if(obj)
			  {
				if(FieldType == 0)
				{
					var isobj = obj.name.indexOf(Fieldname)
					if(isobj >= 0) 
					{   
						ret=obj.name;						
						break;
					}
				}
				else
				{
					
					
					var isobj = obj.id.indexOf(Fieldname);
					if(isobj >= 0) 
					{
						ret=obj.id;
						break;
					}
				}
			  }
		
	}
	
	return ret;
	
}


function numbersonly(e)
{
	//alert('hi');
	var unicode=e.charCode? e.charCode : e.keyCode
	//alert(e.keyCode);
	if (unicode!=8)
	{ //if the key isn't the backspace key (which we should allow)
	if (unicode!=46)
	{ //if the key is "."
	if (unicode<48||unicode>57) //if not a number
	return false //disable key press
	}
	}
}

function ChangeCheckBoxState(id, checkState)
{
  var cb = document.getElementById(id);
  if (cb != null)
	 cb.checked = checkState;
}

function ChangeAllCheckBoxStates(checkState)
{
  // Toggles through all of the checkboxes defined in the CheckBoxIDs array
  // and updates their value to the checkState input parameter
  if (CheckBoxIDs != null)
  {
	 for (var i = 0; i < CheckBoxIDs.length; i++)
		ChangeCheckBoxState(CheckBoxIDs[i], checkState);
  }
}

function PressTextbox(TextCase, args)
{
	var key;
	
	key = event.keyCode;
	//This is Restricting to Enter '
	
	if (key == 39)
	{
		event.keyCode = 0;
		return false;
	}
	if(window.event || !event.which)
	{
		switch (TextCase)
		{
			case('0'): //Text = 0
			{
				break;
			}
			case('1'): //Upper = 1
			{
				if(key >= 97 && key <= 122)
				{
					event.keyCode = key - 32;
					return true;
				}
				break;
			}
			case('2'): //Lower = 2
			{
				if(key >= 65 && key <= 91)
				{
					event.keyCode = key + 32;
					return true
				}
				break;
			}
			case('3'): //Character = 3
			{
				if (!((key >= 65 && key <= 91) || (key >= 97 && key <= 122) || key == 32))
				{
					event.keyCode = 0;
					return true; 
				}
				break;
			}
			case('4'): //CharacterUpper = 4
			{
				if(key >= 97 && key <= 122)
				{
					event.keyCode = key - 32;
					key = key - 32;
				}
				if(!((key >= 65 && key <= 91) || (key == 32)))
				{
					event.keyCode = 0;
					return true; 
				}
				break;
			}
			case('5'): //CharacterLower = 5
			{
				if(key >= 65 && key <= 91)
				{
					event.keyCode = key + 32;
					key = key + 32;
				}
				if(!((key >= 97 && key <= 122) || (key == 32)))
				{
					event.keyCode = 0;
					return true; 
				}
				break;
			}
			case('6'): //Number = 6
			case('7'): //TwoDecimal = 7
			case('8'): //ThreeDecimal = 8
			case('9'): //Round = 9
			case('10'):  //PositiveNumber = 10
			case('11'): //PositiveTwoDecimal = 11
			case('12'): //PositiveThreeDecimal = 12
			case('13'): //PositiveRound = 13
			{
				var TextboxValue = new String();
				TextboxValue = args.value;
				//This if Condition for Positive Number if Not Positive Select then '-' is allowed
				if (TextCase != '10' && TextCase != '11' && TextCase != '12' && TextCase != '13')
				{
					if(key == 45)
					{
						if (TextboxValue == '')
						{
							return true;
						}
						else
						{
							return false;
						}
					}
				}
				//This if Condition for Positive Number if Not Positive Select then '-' is allowed
				
				//This if Condition for Decimal Number if Not Decimal Select then '.' is allowed
				if(TextCase != '9' && TextCase != '13')
				{
					if(key == 46)
					{
						if(TextboxValue.indexOf('.') == -1)
						{
							return true;
						}
						else
						{
							return false;
						}
					}
				}
				//This if Condition for Decimal Number if Not Decimal Select then '.' is allowed
				
				//This is basic checking of Numeric Number
				
				if(!(key >= 48 && key <= 57))
				{
					event.keyCode = 0;
					return true;
				}
				//This is basic checking of Numeric Number
				
				//This is Retriction of After '.'
				if (TextCase == '7' || TextCase == '8' || TextCase == '11' || TextCase == '12')
				{
					if(TextboxValue.indexOf('.') >= 0)
					{
						if (((TextboxValue.indexOf('.') == TextboxValue.length - 3) && (TextCase == '7' || TextCase == '11')) || ((TextboxValue.indexOf('.') == TextboxValue.length - 4) && (TextCase == '8' || TextCase == '12')))
						{
							event.keyCode = 0;
							return true;
						}
					}
				}
				//This is Retriction of After '.'
				break;
			}
			case('14'): //Financial Year
			{
				if(!(key >= 48 && key <= 57))
				{
					if(key!=45)
					{
						event.keyCode = 0;
						return true;
					}
				}
				break;
			}
			case('15'): //EMail
			{
				var i;
			    i = 1;
			    strVal=new String();
			    strVal=document.getElementById(args).value;
			    TextboxValue=document.getElementById(args).value;
			    
			    if(strVal.length == 0)
				    return true;
			    if (TextboxValue.indexOf('@') < 0)
				    i = 0;
			    if (TextboxValue.indexOf('.') < 0)
				    i = 0;
			    if (TextboxValue.indexOf('.') < TextboxValue.indexOf('@'))
				    i = 0;
			    if ((TextboxValue.indexOf('@') + 1) == TextboxValue.indexOf('.'))
				    i = 0;
			    if ((TextboxValue.indexOf('.') + 1) == TextboxValue.length)
				    i = 0;
			    if(i == 0)
			    {
				    alert("Invalid Email Id");	
				    document.getElementById(args).focus();
				    return false;
			    }
			    return true;
			    break;
			}
		}
	}
}
function CheckMaxLength(ControlName,MaxLen,ErrMesage)
{

    if(document.getElementById(ControlName).value.length>MaxLen)
    { 
        alert(ErrMesage);  
        document.getElementById(ControlName).focus(); 
        return false;
    }
     return true;
}

function SetFocus(Element)
{

    //Element.style.backgroundColor = '#97e3ff';
     Element.focus();
          
}
 function GetLatLong(websitepath)
 {
         url = websitepath+"ajaxfunctions.aspx?zip="+txt_zip.value+"&f=4";
     	 MM_findObj('divaddress').style.display='';
		 MM_findObj('divchildaddress').innerHTML = "<p align='center'>Looking for Longitue and Latitue .... <BR>Please wait</p>";
		 fetch_remote_page(url, "divchildaddress", '', '4');
 }  
 
function SetDefaultKay(btnId, el)
    {
        var bt=document.getElementById(btnId);
        if(typeof bt=='object')
        {
            if(navigator.appName.indexOf("Netscape")>(-1))
            {
                var KeyID = el.keyCode ? el.keyCode : el.which;
                if(KeyID == 13)
                {
                    bt.click();
                    return false;
                }
            }
            if(navigator.appName.indexOf("Microsoft Internet Explorer")>(-1))
            {
                if(event.keyCode == 13)
                {
                    bt.click();
                    return false;
                }
            }
        }
    }