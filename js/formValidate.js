/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    function validateForm()
    {
        var str = true;
        var elem = document.forms('inputForm').elements;
        
        for(var i = 0; i < elem.length; i++)
        {
  							if (elem[i].value == "" || elem[i].value == null){
									alert ('Please enter: ' + elem[i].title );
									str=false;
									break;
								}
	        }
        return str;
    }
