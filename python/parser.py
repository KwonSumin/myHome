import requests,re
from bs4 import BeautifulSoup

class customHtmlParser:
    #url : 기본 베이스파싱 url
    #html
    #result
    def __init__(self,url):
        self.baseUrl = url;
        self.html = requests.get(url).text;
    def getParserHtml(self,addUrl,selector):
        url = self.url + addUrl;
        soup = BeautifulSoup(self.html,'html.parser');
        result = soup.select(selector);
        return result;

class addUrl:
    page = {};
    def __init__(self):
        pass;
    def setPage(self,name,url,*querys):
        self.page[name] = {};
        self.page[name]['url'] = url;
        query = '';
        
        index = 0;
        for t in querys:
            if index == 0 :
                t = '?' + t;
            else:
                t = '&' + t;                    
            query += t;
            index+=1;
        self.page[name]['query'] = query;
    def getQueryParam(self,name,id,value):
        patt = re.compile(id + '=[^&]*');
        param = self.page[name]['query'];
        print(param);
        print(patt);
        param = patt.search(param);
        return param;
        
        
t = customHtmlParser('https://torrentkim12.com/');
page = addUrl();
page.setPage('search','bbs/s.php','k=무한도전','page=1');
test = page.getQueryParam('search','k','');
print(test);
