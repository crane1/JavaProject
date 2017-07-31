function deleteOne(id){
	$("#mainForm").attr("action","deleteOne.action?id="+id)
	$("#mainForm").submit()
}

function deleteBatch(){
	$("#mainForm").attr("action","deleteBatch.action")
	$("#mainForm").submit()
}

function UpdateOne(id){
	$("#mainForm").attr("action","alink.action?page=update")
	$("#mainForm").submit()
}