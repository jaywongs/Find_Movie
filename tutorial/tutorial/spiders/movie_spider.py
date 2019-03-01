import scrapy
import json
from scrapy.conf import settings
from tutorial.items import MovieItem


class movieSpider(scrapy.Spider):
    name = "demo"
    movie_id = 1
    allowed_domains = ['movielens.org']
    start_urls = ["https://www.movielens.org/api/movies/"]

    cookie = settings["COOKIE"]
    headers = {
        'Connection': 'keep - alive',  # 保持链接状态
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36'
    }

    def start_requests(self):
        yield scrapy.Request(url=self.start_urls[0] + str(self.movie_id), headers=self.headers, cookies=self.cookie)

    def parse(self, response):
        item = MovieItem()
        entity = json.loads(response.body)
        movie = entity['data']['movieDetails']['movie']
        item['movieid'] = entity['data']['movieDetails']['movieId']
        item['moviename'] = movie['title']
        item['directors'] = ','.join(movie['directors'])
        item['actors'] = ",".join(movie['actors'])
        item['posterPath'] = movie['posterPath']
        item['plotSummary'] = movie['plotSummary']
        item['averageratings'] = movie['avgRating']
        item['numRatings'] = movie['numRatings']
        yield item

        while self.movie_id < 140215:
            self.movie_id += 1
            url = self.start_urls[0] + str(self.movie_id)
            yield scrapy.Request(url, dont_filter=True, callback=self.parse, headers=self.headers, cookies=self.cookie)

