import { useState, useEffect } from 'react';

import axios from "axios";

import './index.css';

function App() {
    const [imagePath, setImagePath] = useState("waiting");
    const [displayText, setDisplayText] = useState("");
    const [inputText, setInputText] = useState("");


    const BASE_URL = "http://localhost:8080"

    const request = (url, method, data={}) => axios({
        method,
        url: `${BASE_URL}${url}`,
        data
    })

    const client = {
        getInitialText: () => request("/scene", "GET")
            .then((response) => { setDisplayText(response.data); }),
        getImage: () => request("/image", "GET")
            .then((response) => { setImagePath(response.data); }),
        getResponse: (data) => request("/?input="+data, "GET")
            .then((response) => { setDisplayText(response.data); }),
    };

    // Function to refresh scene data
    const refreshScene = async () => {
        try {
            await client.getInitialText();
            await client.getImage();
        } catch (error) {
            console.error("Error refreshing scene:", error);
        }
    };

    // Load initial data when component mounts
    useEffect(() => {
        refreshScene();
    }, []); // Empty dependency array means this runs once on mount

    // Set up SSE connection for scene updates
    useEffect(() => {
        const eventSource = new EventSource(`${BASE_URL}/scene-updates`);

        eventSource.addEventListener('sceneChange', (event) => {
            refreshScene();
        });

        eventSource.onerror = (error) => {
            console.error('SSE error:', error);
        };

        // Cleanup on unmount
        return () => {
            eventSource.close();
        };
    }, []);

    const handleInputChange = (e) => {
        setInputText(e.target.value);
    };

    const handleSubmit = () => {
        if (inputText.trim()) {
            client.getResponse(inputText)
            setInputText('');
        }
    };

    return (
        <div className="container">
            <div className="title">
                <h1>Travellers Odyssey</h1>
            </div>
            <div className="wrapper">
                {/* Main Image with Text Overlay */}
                <div className="image-container">
                    <div className="image-wrapper">
                        <img
                            src={`/${imagePath}.png`}
                            alt="Game scene"
                            className="image"
                        />
                    </div>

                    {/* Display Text Bar */}
                    <div className="text-bar">
                        <p className="display-text">
                            {displayText}
                        </p>
                    </div>
                </div>

                {/* Input Text Box with Square Button */}
                <div className="input-container">
                    <div className="input-wrapper">
                        <input
                            type="text"
                            value={inputText}
                            onChange={handleInputChange}
                            placeholder="Type your message..."
                            className="input"
                            onKeyPress={(e) => e.key === 'Enter' && handleSubmit()}
                        />
                        <button
                            onClick={handleSubmit}
                            className="button"
                            aria-label="Submit"
                            disabled={imagePath === "death_screen"}
                        >
                            <svg
                                xmlns="http://www.w3.org/2000/svg"
                                className="icon"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke="currentColor"
                            >
                                <path
                                    strokeLinecap="round"
                                    strokeLinejoin="round"
                                    strokeWidth={3}
                                    d="M13 7l5 5m0 0l-5 5m5-5H6"
                                />
                            </svg>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;