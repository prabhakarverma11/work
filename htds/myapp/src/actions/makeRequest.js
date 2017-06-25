import axios from "axios";
export function makeRequest(method,api,data,headers){
    console.log("Hi from makerequest function");
    console.log(data);
    switch (method.toLowerCase()){
        case "post":{
            console.log(api);
            console.log(data);

            return axios.post(api,data,{headers: headers});
        }
        case "get" :{
            return axios.get(api,{params: data},{headers: headers})
        }
        default:{

        }
    }
}