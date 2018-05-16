window.onload = function(){
    populateReimbursementTable();
}

function populateReimbursementTable(){
    let ajax = new XMLHttpRequest();

    ajax.onreadystatechange = function(){

        if(ajax.readyState === 4 && ajax.status === 200){
            let list = JSON.parse(ajax.responseText);

            for(let reimbursement of list){
                let id = reimbursement.id;
                let amount = reimbursement.amount;
                let cat = reimbursement.category;
                let status = reimbursement.status;
                let recieved = reimbursement.recieved;
                let resolved = reimbursement.resolved;
                
                let row = document.createElement("tr");
                let tdId = document.createElement("td");
                let tdAmount = document.createElement("td");
                let tdCategory = document.createElement("td");
                let tdStatus = document.createElement("td");
                let tdRecieved = document.createElement("td");
                let tdResolved = document.createElement("td");

                tdId.textContent = id;
                tdAmount.textContent = amount;
                tdCategory.textContent = cat;
                tdStatus.textContent = status;
                tdRecieved.textContent = recieved;
                tdResolved.textContent = resolved;  
                
                if(tdStatus.textContent ==="approved"){
                	tdStatus.setAttribute("class", "success");
                }
                else if(tdStatus.textContent ==="rejected"){
                	tdStatus.setAttribute("class", "danger");
                }
                else{
                	tdStatus.setAttribute("class","warning");
                }

                row.appendChild(tdId);
                row.appendChild(tdAmount);
                row.appendChild(tdCategory);
                row.appendChild(tdStatus);
                row.appendChild(tdRecieved);
                row.appendChild(tdResolved);

                document.getElementById("reimbursement").appendChild(row);
                
            }
        }
    }

    ajax.open("GET", "/ERS/getMyReimbursement.ajax")
    ajax.send();
}