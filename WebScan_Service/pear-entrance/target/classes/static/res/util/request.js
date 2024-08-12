const httpPrefix = "http://localhost:8080/coderH"

function get(url, params) {
  return new Promise((resolve, reject) => {
    axios.get(httpPrefix + url, {
      params: params
    }).then(res => {
      resolve(res.data)
    }).catch(error => {
      reject(error.data)
    })
  })
}

function post(url, params) {
  return new Promise((resolve, reject) => {
    // axios.defaults.headers['Content-Type'] = 'Content-Type: application/json;charset=UTF-8'
    axios.post(httpPrefix + url, params)
      .then(res => {
        resolve(res.data)
      })
      .catch(err => {
        reject(err.data)
      })
  })
}

/*
 *  文件上传
 *  url:请求地址
 *  params:参数
 * */
function fileUpload(url, params) {
  return new Promise((resolve, reject) => {
    axios({
      url: httpPrefix + url,
      method: 'post',
      data: params,
      headers: {'Content-Type': 'multipart/form-data'}
    }).then(res => {
      resolve(res)
    })
      .catch(error => {
        reject(error)
      })
  })
}


function getParam(name) {
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if (r != null)
    return decodeURI(r[2]);
  return null;
}

function success(that, msg) {
  if (msg) {
    that.$message.success(msg)
  } else {
    that.$message.success("操作成功！")
  }
}


function error(that, msg) {
  if (msg) {
    that.$message.error(msg)
  } else {
    that.$message.error("操作失败！")
  }
}

