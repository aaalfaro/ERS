window.onload = function(){
    getReimbursements();
}

function getReimbursements(){
    let ajax = new XMLHttpRequest();

    ajax.onreadystatechange = function(){

        if(ajax.readyState === 4 && ajax.status === 200){
        	let list = JSON.parse(ajax.responseText);

            for(let reimbursement of list){
                let id = reimbursement.id;
                let requester = reimbursement.e_id;
                let manager = reimbursement.fm_id;
                let amount = reimbursement.amount;
                let cat = reimbursement.category;
                let status = reimbursement.status;
                let recieved = reimbursement.recieved;
                let resolved = reimbursement.resolved;
                let image = reimbursement.image;
                
                let form = document.createElement("form");
                form.setAttribute("method","POST");
                form.setAttribute("action","resolve.do");
                
                let row = document.createElement("tr");
                let tdId = document.createElement("td");
                let tdAmount = document.createElement("td");
                let tdCategory = document.createElement("td");
                let tdStatus = document.createElement("td");
                let tdRecieved = document.createElement("td");
                let tdResolved = document.createElement("td");
                let tdRequester = document.createElement("td");
                let tdManager = document.createElement("td");
                let tdButton = document.createElement("td");
                let approve = document.createElement("button");
                let tdImage = document.createElement("td");
                
                let link = document.createElement("a");
                link.setAttribute("href","data:image/png;base64," + image);
                
                link.textContent = "show image";
                tdImage.appendChild(link);
                
                approve.setAttribute("type","submit");
                approve.setAttribute("class","btn btn-success");
                approve.setAttribute("value","Approved");
                approve.setAttribute("name","approve");
                approve.textContent = "Approve";

                let reject = document.createElement("button");
                reject.setAttribute("type","submit");
                reject.setAttribute("class","btn btn-danger");
                reject.setAttribute("value","Rejected");
                reject.setAttribute("name","reject");
                reject.textContent = "Reject";

                tdButton.appendChild(approve);
                tdButton.appendChild(reject);

                tdId.textContent = id;
                tdAmount.textContent = amount;
                tdCategory.textContent = cat;
                tdStatus.textContent = status;
                tdRecieved.textContent = recieved;
                tdResolved.textContent = resolved; 
                tdRequester.textContent = requester;
                tdManager.textContent = manager;
                
                if(status =='Approved'){
                	row.setAttribute("class", "success");
                }
                else if(status =='Rejected'){
                	row.setAttribute("class", "danger");
                }
                else{
                	row.setAttribute("class","warning");
                }
                
                
                row.appendChild(tdId);
                row.appendChild(tdRequester);
                row.appendChild(tdManager);
                row.appendChild(tdCategory);
                row.appendChild(tdAmount);
                row.appendChild(tdRecieved);
                row.appendChild(tdResolved);
                row.appendChild(tdStatus);
                
                
                let input = document.createElement("input");
                input.setAttribute("name","reimbursement");
                input.setAttribute("type","hidden");
                input.setAttribute("value",id);
                
                form.appendChild(input);
                form.appendChild(tdButton);
                row.appendChild(tdImage);
                if(status =='pending')
                	row.appendChild(form);
                
                document.getElementById("reimbursement").appendChild(row);
            }
        }
    }
    ajax.open("GET", "http://localhost:8080/ERS/FinancialManagerList.ajax")
    ajax.send();

}