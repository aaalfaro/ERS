window.onload = function(){
    getReimbursements();
}

function getReimbursements(){
    let ajax = new XMLHttpRequest();

    ajax.onreadystatechange = function(){

        if(ajax.readyState === 4 && ajax.status === 200){
        	let list = JSON.parse(ajax.responseText);

            for(let Employee of list){
                let id = Employee.id;
                let title = Employee.title;
                let first = Employee.fname;
                let last = Employee.lname;
                let telephone = Employee.phone;
                let address = Employee.address;
                
                               
                let row = document.createElement("tr");
                let tdId = document.createElement("td");
                let tdTitle = document.createElement("td");
                let tdFname = document.createElement("td");
                let tdLname = document.createElement("td");
                let tdPhone = document.createElement("td");
                let tdAddress = document.createElement("td");

                tdId.textContent = id;
                tdTitle.textContent = title;
                tdFname.textContent = first;
                tdLname.textContent = last;
                tdPhone.textContent = telephone;
                tdAddress.textContent = address; 
                
                
                row.appendChild(tdId);
                row.appendChild(tdTitle);
                row.appendChild(tdFname);
                row.appendChild(tdLname);
                row.appendChild(tdPhone);
                row.appendChild(tdAddress);

                
                document.getElementById("employee").appendChild(row);
            }
        }
    }
    ajax.open("GET", "http://localhost:8080/ERS/getEmployees.ajax")
    ajax.send();

}


