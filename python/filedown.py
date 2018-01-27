from requests import get  # to make GET request
import shutil
#url = 'https://autohotkey.com/download/ahk-install.exe';
url = 'https://www.naver.com';
file_name = 'test.html';
# Read the first 64 bytes of the file inside the .gz archive located at `url`
#url = 'http://example.com/something.gz'

def download(url, file_name):
    # open in binary mode
    file = open(file_name, "wb");
    # get request
    response = get(url)
    # write to file
    file.write(response.content);
        
download(url,file_name)