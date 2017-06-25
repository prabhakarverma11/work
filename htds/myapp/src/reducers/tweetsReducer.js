export default function reducer(state={
    tweets: [],
    fetching: false,
    fetched: false,
    error: null,
}, action) {
    const newState = Object.assign({},state);
    switch (action.type) {
        case "FETCH_TWEETS": {
            newState.fetching = true;
            break;
        }
        case "FETCH_TWEETS_REJECTED": {
            newState.fetching = false;
            newState.error= action.payload;
            break;
        }
        case "FETCH_TWEETS_FULFILLED": {
            newState.fetching = false;
            newState.fetched = true;
            newState.tweets = action.payload;
            break;
        }
        case "ADD_TWEET": {
            newState.tweets.push(action.payload);
            break;
        }
        case "UPDATE_TWEET": {
            const { id, text } = action.payload;
            const newTweets = state.tweets.map((a)=>{a});
            const tweetToUpdate = newTweets.findIndex(tweet => tweet.id === id)
            newTweets[tweetToUpdate] = action.payload;

            newState.tweets = newTweets;
            break;
        }
        case "DELETE_TWEET": {
            newState.tweets =  newState.tweets.filter(tweet => tweet.id !== action.payload);
            break;
        }
    }
    return newState;
}