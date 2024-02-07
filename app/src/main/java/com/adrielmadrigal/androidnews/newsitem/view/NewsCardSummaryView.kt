package com.adrielmadrigal.androidnews.newsitem.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adrielmadrigal.androidnews.newsapi.Article
import com.adrielmadrigal.androidnews.newsapi.NewsResponse

@Composable
fun NewsCardSummaryView(article: Article) {
    Row() {
        Text(text = article.title)
//        AsyncImage(
//            model = "https://www.eluniversal.com.mx/resizer/cQcHNJC1eLxhGADxw2SQqTBf7kk=/482x276/cloudfront-us-east-1.images.arcpublishing.com/eluniversal/A2KDZUUSOVBJTAFQC2D6RQ2234.jpg",
//            contentDescription = "Image random",
//            modifier = Modifier.size(80.dp))
    }
}

@Preview
@Composable
fun NewsCardSummaryView_Preview() {
    val article = Article(
        "Dummiest News",
        "Random content that is going to be displayed",
        "https://www.eluniversal.com.mx/resizer/cQcHNJC1eLxhGADxw2SQqTBf7kk=/482x276/cloudfront-us-east-1.images.arcpublishing.com/eluniversal/A2KDZUUSOVBJTAFQC2D6RQ2234.jpg")
    NewsCardSummaryView(article)
}