from fastapi import FastAPI, Cookie
from typing import Optional
import requests


app = FastAPI()

@app.get("/helloworld")
def helloworld(JSESSIONID: Optional[str] = Cookie(None)):
    print(JSESSIONID)

    try:
        cookie = {
            "JSESSIONID": JSESSIONID
        }
        response = requests.get("http://localhost:12610/users/info", cookies=cookie)
    except Exception as e:
        print(f"연결 실패: {e}")
    else:
        if response.ok:
            return "hello world"
        else:
            return "세션이 만료되었습니다. or 세션이 올바르지 않습니다."
