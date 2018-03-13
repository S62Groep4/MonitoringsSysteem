function reloadWebsites() {


    var elements = document.getElementsByClassName('url-input');

    for (var i = 0; i < elements.length; i++) {
        var item = elements[i];
        RemoveClasses(item);

       item.parentElement.parentElement.classList.add('bg-warning');

        //UrlExists(item);
    }
}

function RemoveClasses(item) {
    item.parentElement.parentElement.classList.remove('bg-warning');
    item.parentElement.parentElement.classList.remove('bg-success');
    item.parentElement.parentElement.classList.remove('bg-danger');
}


function UrlExists(url){

    $.ajax({
        url:      url.value,
        dataType: 'html',
        type:     'GET',
        complete:  function(xhr){
            console.log(xhr)
            if(xhr.status === 200|| xhr.status === 0){
                RemoveClasses(url);
                url.parentElement.parentElement.classList.add('bg-success');

                // file was found
            }
            else if(xhr.status >= 404 ){
                console.log(url);
                RemoveClasses(url);
                url.parentElement.parentElement.classList.add('bg-danger');
                // 404 not found
            }
        }
    });
}