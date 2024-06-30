const MAX_AGE =  150;

function checkDate(date) {
  if (!date){
    throw new Error("'Please enter your date of birth.'")
  }
  if (!date.match(/^[12]\d{3}-[0-1]?\d-[0-3]?\d$/)) {
    throw new Error( 'Please use the YYYY-MM-DD format.');
  }
  const dateTime=new Date (date);
  if (isNaN(dateTime.valueOf() )){
    throw new Error("This is not a valid date")
  }
  return dateTime
}

export function checkDateOfBirth(dateTxt){
  const date = checkDate(dateTxt);
  const dateTime= date.getTime();
  const now=new Date();
  if (dateTime >= now.getTime()){
    throw new Error ('Your date of birth should be in the past.');
  }
  const longAgo = new Date(now);
  longAgo.setFullYear(longAgo.getFullYear() - MAX_AGE);
  if (dateTime < longAgo.getTime()){
    throw new Error ('Your are too old to use this site.');
  }
  return date;
}

//console.log(checkDateOfBirth("2110-06-31"));