package com.adrielmadrigal.androidnews.newsitem.view

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adrielmadrigal.androidnews.newsapi.data.model.ArticleModel

@Composable
fun NewsCardSummaryView(article: ArticleModel) {
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
    val articleModelApp = ArticleModel(
        "Dummiest News",
        "Random content that is going to be displayed",
        "https://www.eluniversal.com.mx/resizer/cQcHNJC1eLxhGADxw2SQqTBf7kk=/482x276/cloudfront-us-east-1.images.arcpublishing.com/eluniversal/A2KDZUUSOVBJTAFQC2D6RQ2234.jpg")
    NewsCardSummaryView(articleModelApp)
}