import Vue from "vue";


export default {

  webClient:{
    post(url,data,callBack){
      httpPost(url,data,callBack);
    }
  },

  test:{
    valid(){
      doTest( );
    }    
  }

}


function httpPost(url, data,callBack) {

  Vue.http.post(url, data, {
      headers: {
        "Content-Type": "application/json"
      }
    })
    .then(
      response => {
        
        if (response.body.success) {
            callBack(response.body.data, response);
        }  
      },
  
    );

}

function doTest(){
  alert("It works")
}


