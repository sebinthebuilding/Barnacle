const wallet_connect = document.getElementById(`connect_wallet`)

const tokens_button = document.getElementById(`tokens`);
const holdings_button = document.getElementById(`holdings`);
const analytics_button = document.getElementById(`analytics`);

const tokens_page = document.getElementById(`tokens_page`);
const holdings_page = document.getElementById(`holdings_page`);
const analytics_page = document.getElementById(`analytics_page`);

tokens_button.addEventListener(`click`, () => {
    tokens_page.style.display=`block`;
    holdings_page.style.display=`none`;
    analytics_page.style.display=`none`;
})

holdings_button.addEventListener(`click`, () => {
    tokens_page.style.display=`none`;
    holdings_page.style.display=`block`;
    analytics_page.style.display=`none`;
})

analytics_button.addEventListener(`click`, () => {
    tokens_page.style.display=`none`;
    holdings_page.style.display=`none`;
    analytics_page.style.display=`block`;
})