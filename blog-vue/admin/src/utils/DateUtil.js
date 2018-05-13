export function formatDate(date, fmt) {
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    let month = date.getMonth() + 1 < 10 ? `0${date.getMonth()+1}` : date.getMonth()+1 
    let day = date.getDate() < 10 ? `0${date.getDate()}` : date.getDate()
    let hour = date.getHours() < 10 ? `0${date.getHours()}` : date.getHours()
    let min = date.getMinutes() < 10 ? `0${date.getMinutes()}` : date.getMinutes()
    let sec = date.getSeconds() < 10 ? `0${date.getSeconds()}` : date.getSeconds()

    let o = {
        'M+': month,
        'd+': day,
        'h+': hour,
        'm+': min,
        's+': sec
    };
    for (let k in o) {
        if (new RegExp(`(${k})`).test(fmt)) {
            let str = o[k] + '';
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
        }
    }
    return fmt;
 };
 function padLeftZero(str) {
    return ('00' + str).substr(str.length);
 }
 
 //计算一个日期字符串与当前日期相差值 
 //输入的参数形式如：2012-12-12 12:12:12 
 //返回相差值的字符串 
 export function GetDateDiff(dateBegin) 
 { 
     // 可以将2012 - 12 - 12 12 : 12 : 12字符串转为JS中的时期对象, 
     // 因为默认情况下只把持2000 / 05 / 05这样形式的字符串转为时间对象 
     // var dateBegin = new Date(datetime.replace(/-/g, "/")); 
     var dateEnd = new Date(); 
     var dateDiff = dateEnd.getTime() - dateBegin.getTime(); 
     
     // 计算相差的天数 
     var dayDiff = Math.floor(dateDiff / (24 * 3600 * 1000)); 
     //console.log(dayDiff)
     
     var returnstr = ""; 
     if(dayDiff > 2){  //前天以前就直接返回时间字符串 
         return dayDiff+"天前"; 
     } else {//前天以来的处理 
         switch (dayDiff) { 
             case 2 : 
                 returnstr += "前天"; 
                 break; 
             case 1 : 
                 returnstr += "昨天"; 
                 break; 
             case 0 : //对今天的操作 
                 var minuteleft = Math.floor(dateDiff / (60 * 1000)); //计算相差的分钟数 
                 if(minuteleft > 30) { 
                     returnstr = Math.ceil(minuteleft / 60) +"小时前"; 
                 } else if (minuteleft == 0) { 
                     returnstr += Math.floor(dateDiff / 1000) + "秒前"; 
                 } else { 
                     returnstr += minuteleft + "分钟前"; 
                 } 
         } 
         return returnstr; 
     } 
 } 